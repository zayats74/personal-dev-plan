import sbt.*

object Dependencies {
  val Scala = "3.7.3"

  object cats {
    private val version       = "2.13.0"
    private val effectVersion = "3.7-4972921"

    val core         = "org.typelevel" %% "cats-core"          % version
    val effect       = "org.typelevel" %% "cats-effect"        % effectVersion
    val effectKernel = "org.typelevel" %% "cats-effect-kernel" % effectVersion
  }

  object weaver {
    private val version = "0.8.4"

    val cats = "com.disneystreaming" %% "weaver-cats" % version
  }

  object iron {
    private val version = "3.2.1"
    val core            = "io.github.iltotore" %% "iron"            % version
    val pureconfig      = "io.github.iltotore" %% "iron-pureconfig" % version
    val doobie          = "io.github.iltotore" %% "iron-doobie"     % version
  }

  object pureconfig {
    private val version = "0.17.9"
    val core            = "com.github.pureconfig" %% "pureconfig-core" % version
  }

  object doobie {
    private val version = "1.0.0-RC10"
    val core            = "org.tpolecat" %% "doobie-core"     % version
    val free            = "org.tpolecat" %% "doobie-free"     % version
    val postgres        = "org.tpolecat" %% "doobie-postgres" % version
    val hikari          = "org.tpolecat" %% "doobie-hikari"   % version
  }

  object flyway {
    private val version = "9.16.0"
    val core            = "org.flywaydb" % "flyway-core" % version
  }

  object postgres {
    private val version = "42.7.1"
    val postgresql      = "org.postgresql" % "postgresql" % version
  }

  object cdimascio {
    private val version = "3.0.0"
    val env             = "io.github.cdimascio" % "dotenv-java" % version
  }

  val pdpLibs: Seq[ModuleID] =
    Seq(
      cats.core,
      cats.effect,
      cats.effectKernel,
      iron.core,
      iron.pureconfig,
      iron.doobie,
      pureconfig.core,
      doobie.core,
      doobie.free,
      doobie.postgres,
      doobie.hikari,
      flyway.core,
      postgres.postgresql,
      cdimascio.env
    )

  val testLibs: Seq[ModuleID] =
    Seq(
      weaver.cats
    ).map(_ % Test)
}
