package ru.scalabook.pdp.model.services.mock

import cats.data.NonEmptyVector
import cats.effect.*
import ru.scalabook.pdp.model.UserId
import ru.scalabook.pdp.model.dto.CreateUserType
import ru.scalabook.pdp.model.entity.UserType
import ru.scalabook.pdp.model.entity.UserType.UserTypeId
import ru.scalabook.pdp.model.services.UserTypeService

private[services] class MockUserTypeService(
    userTypes: Ref[IO, Map[UserTypeId, UserType]],
    nextId: Ref[IO, UserTypeId]
) extends UserTypeService[IO]:
  override def create(newItem: CreateUserType): IO[UserTypeId] =
    for
      id <- nextId.getAndUpdate(id => UserTypeId.applyUnsafe(id.value + 1))
      userType = UserType(
        id = id,
        name = newItem.name,
        userId = newItem.userId,
        displayed = newItem.displayed,
        ordinal = newItem.ordinal
      )

      _ <- update(userType)
    yield id

  override def get(id: UserTypeId): IO[Option[UserType]] =
    userTypes.get.map(_.get(id))

  override def getByUser(userId: UserId): IO[Vector[UserType]] =
    userTypes.get.map(_.values.filter(_.userId == userId).toVector)

  override def update(userType: UserType): IO[Unit] =
    userTypes.update(curMap => curMap + (userType.id -> userType))

  override def updateAll(items: NonEmptyVector[UserType]): IO[Unit] =
    userTypes.update(_ ++ items.toVector.map(t => t.id -> t))

  override def delete(id: UserTypeId): IO[Unit] =
    userTypes.update(_ - id)

end MockUserTypeService

object MockUserTypeService:
  def make: Resource[IO, UserTypeService[IO]] =
    Resource.eval:
      for
        types <- Ref[IO].of(Map.empty[UserTypeId, UserType])
        id    <- Ref[IO].of(UserTypeId(0))
      yield new MockUserTypeService(types, id)
