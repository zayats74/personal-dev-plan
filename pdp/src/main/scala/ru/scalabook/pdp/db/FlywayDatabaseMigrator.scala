package ru.scalabook.pdp.db

import cats.effect.IO
import org.flywaydb.core.Flyway
import ru.scalabook.pdp.config.{DatabaseUrl, NonEmptyString}

final class FlywayDatabaseMigrator extends DatabaseMigrator[IO] {

  override def migrate(
      url: DatabaseUrl,
      user: NonEmptyString,
      password: NonEmptyString
  ): IO[Int] =
    IO {
      val flyway: Flyway = Flyway.configure()
        .dataSource(url.value, user.value, password.value)
        .locations(FlywayDatabaseMigrator.migrationLocation)
        .load()
      flyway.migrate().migrationsExecuted
    }
}

object FlywayDatabaseMigrator {
  private val migrationLocation = "classpath:db/migrations"
}
