package ru.scalabook.pdp.model.services

import cats.Monad
import cats.data.NonEmptyVector
import ru.scalabook.pdp.model.UserId
import ru.scalabook.pdp.model.dto.CreateGoal
import ru.scalabook.pdp.model.entity.Goal
import ru.scalabook.pdp.model.entity.Goal.GoalId

private[services] trait GoalService[F[_]: Monad]:
  def create(goal: CreateGoal): F[GoalId]

  def get(id: GoalId): F[Option[Goal]]

  def getByUser(userId: UserId): F[Vector[Goal]]

  def update(goal: Goal): F[Unit]

  def updateAll(goals: NonEmptyVector[Goal]): F[Unit]

  def delete(id: GoalId): F[Unit]
