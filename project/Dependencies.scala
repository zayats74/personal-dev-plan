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
    val core            = "io.github.iltotore" %% "iron" % version
  }

  val pdpLibs: Seq[ModuleID] =
    Seq(
      cats.core,
      cats.effect,
      cats.effectKernel,
      iron.core
    )

  val testLibs: Seq[ModuleID] =
    Seq(
      weaver.cats
    ).map(_ % Test)
}
