package ru.scalabook.pdp.config

import io.github.iltotore.iron.constraint.string.{Blank, Match}
import io.github.iltotore.iron.pureconfig.given
import pureconfig.*
import io.github.iltotore.iron.*

import scala.language.implicitConversions

type NonEmptyString = NonEmptyString.T
object NonEmptyString extends RefinedType[String, Not[Blank]]

type DatabaseUrl = DatabaseUrl.T
object DatabaseUrl
    extends RefinedType[String, Match[
      """(\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]"""
    ]]

final case class DatabaseConfig(
    driver: NonEmptyString,
    url: DatabaseUrl,
    username: NonEmptyString,
    password: NonEmptyString
) derives ConfigReader
