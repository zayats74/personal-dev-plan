package ru.scalabook.pdp.model.entity

import ru.scalabook.pdp.model.{Ordinal, UserId}
import io.github.iltotore.iron.RefinedType
import io.github.iltotore.iron.constraint.all.{
  GreaterEqual,
  MaxLength,
  MinLength,
  Trimmed
}
import UserType.*

final case class UserType(
    id: UserTypeId,
    name: UserTypeName,
    userId: UserId,
    displayed: Boolean,
    ordinal: Ordinal
)
object UserType:
  type UserTypeId = UserTypeId.T
  object UserTypeId extends RefinedType[Int, GreaterEqual[0]]

  type UserTypeName = UserTypeName.T
  object UserTypeName
      extends RefinedType[String, MinLength[2] & MaxLength[30] & Trimmed]
