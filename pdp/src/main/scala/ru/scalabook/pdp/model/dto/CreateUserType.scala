package ru.scalabook.pdp.model.dto

import ru.scalabook.pdp.model.{Ordinal, UserId}
import ru.scalabook.pdp.model.entity.UserType.*

final case class CreateUserType(
    name: UserTypeName,
    userId: UserId,
    displayed: Boolean,
    ordinal: Ordinal
)
