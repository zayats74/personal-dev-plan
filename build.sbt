import Dependencies.*

ThisBuild / scalacOptions ++=
  Seq(
    "-deprecation",
    "-explain",
    "-Wunused:imports",
    "-unchecked",
    "-Xfatal-warnings",
    "-feature",
    "-Wnonunit-statement"
  )

ThisBuild / scalaVersion := Scala

ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .aggregate(pdp)
  .settings(
    name           := "root",
    publish / skip := true
  )

lazy val pdp = (project in file("pdp"))
  .settings(name := "Personal-Development-Plan")
  .settings(
    libraryDependencies ++= pdpLibs,
    libraryDependencies ++= testLibs
  )
