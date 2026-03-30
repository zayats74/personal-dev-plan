package ru.scalabook.pdp.model.services

import cats.Monad
import cats.data.NonEmptyVector
import ru.scalabook.pdp.model.UserId
import ru.scalabook.pdp.model.dto.CreateSection
import ru.scalabook.pdp.model.entity.Section
import ru.scalabook.pdp.model.entity.Section.SectionId

private[services] trait SectionService[F[_]: Monad]:
  def create(section: CreateSection): F[SectionId]

  def get(id: SectionId): F[Option[Section]]

  def getByUser(userId: UserId): F[Vector[Section]]

  def update(section: Section): F[Unit]

  def updateAll(sections: NonEmptyVector[Section]): F[Unit]

  def delete(id: SectionId): F[Unit]
