package ru.scalabook.pdp.db

import ru.scalabook.pdp.config.DatabaseUrl
import ru.scalabook.pdp.config.NonEmptyString

trait DatabaseMigrator[F[_]]:
  def migrate(
      url: DatabaseUrl,
      user: NonEmptyString,
      password: NonEmptyString
  ): F[Int]
