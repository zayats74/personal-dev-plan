addCommandAlias("com", "compile; Test / compile")
addCommandAlias("fix", "scalafmtSbt; scalafmtAll; scalafixAll")
addCommandAlias(
  "prePush",
  "clean; com; test; fix; undeclaredCompileDependencies; unusedCompileDependencies"
)
addCommandAlias("fullCheck", "prePush; dependencyUpdates")
