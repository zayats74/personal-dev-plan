package ru.scalabook.pdp.localization

import io.github.iltotore.iron.pureconfig.given
import pureconfig.*
import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.all.*

type NonEmptyString = NonEmptyString.T
object NonEmptyString extends RefinedType[String, Not[Empty] & Trimmed]

type LanguageCode = LanguageCode.T
object LanguageCode extends RefinedType[String, MinLength[2] & MaxLength[3]]

type LanguageName = LanguageName.T
object LanguageName extends RefinedType[String, MinLength[2] & MaxLength[20]]

final case class TaskStatusConfig(
    inProgress: NonEmptyString,
    planned: NonEmptyString,
    backlog: NonEmptyString,
    completed: NonEmptyString
)

final case class TaskTypesConfig(
    book: NonEmptyString,
    podcast: NonEmptyString,
    video: NonEmptyString,
    course: NonEmptyString,
    article: NonEmptyString
)

final case class LanguageConfig(
    code: LanguageCode,
    name: LanguageName,
    taskStatus: TaskStatusConfig,
    taskTypes: TaskTypesConfig
) derives ConfigReader

type Languages = List[LanguageConfig] :| MinLength[2]

final case class LocalizationConfig(languages: Languages) derives ConfigReader

final case class Config(localization: LocalizationConfig) derives ConfigReader
