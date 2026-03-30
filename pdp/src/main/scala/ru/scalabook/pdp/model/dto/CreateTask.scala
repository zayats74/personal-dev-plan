package ru.scalabook.pdp.model.dto

import ru.scalabook.pdp.model.entity.Goal.GoalId
import ru.scalabook.pdp.model.entity.Section.SectionId
import ru.scalabook.pdp.model.entity.UserType.UserTypeId
import ru.scalabook.pdp.model.enums.{TaskStatus, TaskType}
import ru.scalabook.pdp.model.{
  Authors,
  Episodes,
  Link,
  Ordinal,
  Pages,
  Platform,
  TaskName,
  TaskStep,
  UserId
}

import java.time.LocalDate
import scala.concurrent.duration.FiniteDuration

sealed trait CreateTask:
  val name: TaskName
  val userId: UserId
  val taskType: TaskType
  val taskStatus: TaskStatus
  val sectionId: SectionId
  val goalId: GoalId
  val ordinal: Ordinal
  val startDate: Option[LocalDate]
  val endDate: Option[LocalDate]
  val information: String
  val plan: List[TaskStep]

final case class CreateBookTask(
    name: TaskName,
    userId: UserId,
    taskStatus: TaskStatus,
    sectionId: SectionId,
    goalId: GoalId,
    ordinal: Ordinal,
    startDate: Option[LocalDate],
    endDate: Option[LocalDate],
    information: String,
    plan: List[TaskStep],
    authors: Authors,
    pages: Pages
) extends CreateTask:
  val taskType: TaskType = TaskType.Book

final case class CreateArticleTask(
    name: TaskName,
    userId: UserId,
    taskStatus: TaskStatus,
    sectionId: SectionId,
    goalId: GoalId,
    ordinal: Ordinal,
    startDate: Option[LocalDate],
    endDate: Option[LocalDate],
    information: String,
    plan: List[TaskStep],
    authors: Authors,
    link: Link,
    duration: FiniteDuration
) extends CreateTask:
  val taskType: TaskType = TaskType.Article

final case class CreatePodcastTask(
    name: TaskName,
    userId: UserId,
    taskStatus: TaskStatus,
    sectionId: SectionId,
    goalId: GoalId,
    ordinal: Ordinal,
    startDate: Option[LocalDate],
    endDate: Option[LocalDate],
    information: String,
    plan: List[TaskStep],
    authors: Authors,
    link: Link,
    episodes: Episodes,
    episodeDuration: FiniteDuration
) extends CreateTask:
  val taskType: TaskType = TaskType.Podcast

final case class CreateVideoTask(
    name: TaskName,
    userId: UserId,
    taskStatus: TaskStatus,
    sectionId: SectionId,
    goalId: GoalId,
    ordinal: Ordinal,
    startDate: Option[LocalDate],
    endDate: Option[LocalDate],
    information: String,
    plan: List[TaskStep],
    authors: Authors,
    platform: Platform,
    link: Link,
    duration: FiniteDuration
) extends CreateTask:
  val taskType: TaskType = TaskType.Video

final case class CreateCourseTask(
    name: TaskName,
    userId: UserId,
    taskStatus: TaskStatus,
    sectionId: SectionId,
    goalId: GoalId,
    ordinal: Ordinal,
    startDate: Option[LocalDate],
    endDate: Option[LocalDate],
    information: String,
    plan: List[TaskStep],
    authors: Authors,
    platform: Platform,
    link: Link,
    duration: FiniteDuration
) extends CreateTask:
  val taskType: TaskType = TaskType.Course

final case class CreateUserTypeTask(
    name: TaskName,
    userId: UserId,
    userTypeId: UserTypeId,
    taskStatus: TaskStatus,
    sectionId: SectionId,
    goalId: GoalId,
    ordinal: Ordinal,
    startDate: Option[LocalDate],
    endDate: Option[LocalDate],
    information: String,
    plan: List[TaskStep],
    duration: FiniteDuration
) extends CreateTask:
  val taskType: TaskType = TaskType.Custom
