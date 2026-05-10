package ru.scalabook.pdp

import cats.effect.unsafe.implicits.global
import cats.effect.{ExitCode, IO, IOApp}
import com.typesafe.config.{Config, ConfigFactory}
import doobie.Transactor
import io.github.cdimascio.dotenv.Dotenv
import pureconfig.{ConfigReader, ConfigSource}
import ru.scalabook.pdp.config.DatabaseConfig
import ru.scalabook.pdp.db.{DatabaseMigrator, FlywayDatabaseMigrator}

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    val migrator: DatabaseMigrator[IO] = new FlywayDatabaseMigrator

    val dotenv = Dotenv.configure().filename(".env").load()

    dotenv.entries().forEach { entry =>
      System.setProperty(entry.getKey, entry.getValue)
    }

    val configsIO =
      for
        cfg      <- IO(ConfigFactory.load(getClass.getClassLoader))
        dbConfig <- loadConfig[DatabaseConfig](cfg, "database")
      yield dbConfig

    val program =
      for
        configs <- configsIO
        dbConfig = configs
        _ <-
          migrator.migrate(dbConfig.url, dbConfig.username, dbConfig.password)
      yield
        val tx = Transactor.fromDriverManager[IO](
          driver = dbConfig.driver.value,
          url = dbConfig.url.value,
          user = dbConfig.username.value,
          password = dbConfig.password.value,
          logHandler = None
        )

    program.attempt.unsafeRunSync() match
      case Left(e) =>
        println("*** An error occured! ***")
        IO {
          ExitCode.Error
        }
      case Right(r) => IO { ExitCode.Success }
  }

  private def loadConfig[A: ConfigReader](
      cfg: Config,
      namespace: String
  ): IO[A] =
    val result = ConfigSource.fromConfig(cfg).at(namespace).load[A]
    IO.fromEither(result.left.map(error =>
      new IllegalArgumentException(error.prettyPrint())
    ))
}
