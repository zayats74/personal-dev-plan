package ru.scalabook.pdp.model.services

import cats.Monad
import ru.scalabook.pdp.model.{TaskId, UserId}
import ru.scalabook.pdp.model.dto.CreateTask
import ru.scalabook.pdp.model.entity.Task
import ru.scalabook.pdp.model.enums.TaskType

private[services] trait TaskService[F[_]: Monad]:
  def create(task: CreateTask): F[TaskId]

  def get(id: TaskId, taskType: TaskType): F[Option[Task]]

  def getByUser(userId: UserId): F[Vector[Task]]

  def update(task: Task): F[Unit]

  def delete(id: TaskId, taskType: TaskType): F[Unit]
