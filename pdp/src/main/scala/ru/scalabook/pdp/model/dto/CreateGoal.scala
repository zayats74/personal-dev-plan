package ru.scalabook.pdp.model.dto

import ru.scalabook.pdp.model.{Ordinal, UserId}
import ru.scalabook.pdp.model.entity.Goal.*

case class CreateGoal(
    name: GoalName,
    userId: UserId,
    displayed: Boolean,
    ordinal: Ordinal
)
