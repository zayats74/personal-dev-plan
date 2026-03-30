package ru.scalabook.pdp.model.services

import cats.Monad
import cats.data.NonEmptyVector
import ru.scalabook.pdp.model.UserId
import ru.scalabook.pdp.model.dto.CreateUserType
import ru.scalabook.pdp.model.entity.UserType
import ru.scalabook.pdp.model.entity.UserType.UserTypeId

private[services] trait UserTypeService[F[_]: Monad]:
  def create(newItem: CreateUserType): F[UserTypeId]

  def get(id: UserTypeId): F[Option[UserType]]

  def getByUser(userId: UserId): F[Vector[UserType]]

  def update(userType: UserType): F[Unit]

  def updateAll(userTypes: NonEmptyVector[UserType]): F[Unit]

  def delete(id: UserTypeId): F[Unit]
