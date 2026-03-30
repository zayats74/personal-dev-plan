package ru.scalabook.pdp.model

import io.github.iltotore.iron.RefinedType
import io.github.iltotore.iron.constraint.all.{
  MaxLength,
  MinLength,
  Positive,
  Trimmed
}

import java.util.UUID

opaque type TaskId = UUID
object TaskId:
  def apply(uuid: UUID): TaskId = uuid

type TaskName = TaskName.T
object TaskName
    extends RefinedType[String, MinLength[2] & MaxLength[200] & Trimmed]

type Ordinal = Ordinal.T
object Ordinal extends RefinedType[Int, Positive]:
  val Max: T = Ordinal(1000)

type TaskStep = TaskStep.T
object TaskStep
    extends RefinedType[String, MinLength[2] & MaxLength[200] & Trimmed]

opaque type UserId = UUID
object UserId:
  def apply(uuid: UUID): UserId = uuid

type Authors = Authors.T
object Authors extends RefinedType[String, MinLength[1] & Trimmed]

type Pages = Pages.T
object Pages extends RefinedType[Int, Positive]

type Link = Link.T
object Link extends RefinedType[String, MinLength[1] & Trimmed]

type Episodes = Episodes.T
object Episodes extends RefinedType[Int, Positive]

type Platform = Platform.T
object Platform extends RefinedType[String, MinLength[1] & Trimmed]
