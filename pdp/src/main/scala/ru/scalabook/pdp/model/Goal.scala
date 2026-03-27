package ru.scalabook.pdp.model

import io.github.iltotore.iron.RefinedType
import io.github.iltotore.iron.constraint.all.{MaxLength, MinLength, Trimmed}
import io.github.iltotore.iron.constraint.numeric.GreaterEqual
import ru.scalabook.pdp.model.Goal.*

final case class Goal(
    id: GoalId,
    name: GoalName,
    userId: UserId,
    displayed: Boolean,
    ordinal: Ordinal
)

object Goal:
  type GoalId = GoalId.T
  object GoalId extends RefinedType[Int, GreaterEqual[0]]

  type GoalName = GoalName.T
  object GoalName
      extends RefinedType[String, MinLength[2] & MaxLength[200] & Trimmed]
