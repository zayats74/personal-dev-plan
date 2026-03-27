package ru.scalabook.pdp.model

import ru.scalabook.pdp.model.Goal.GoalId
import ru.scalabook.pdp.model.Section.SectionId
import ru.scalabook.pdp.model.UserType.UserTypeId
import ru.scalabook.pdp.model.enums.TaskType.{
  Article,
  Book,
  Course,
  Custom,
  Podcast,
  Video
}
import ru.scalabook.pdp.model.enums.{TaskStatus, TaskType}

import java.time.LocalDate
import scala.concurrent.duration.{FiniteDuration, MILLISECONDS}

sealed trait Task:
  val id: TaskId
  val name: TaskName
  val userId: UserId
  val taskType: TaskType
  val taskStatus: TaskStatus
  val sectionId: SectionId
  val goalId: GoalId
  val ordinal: Ordinal
  val startDate: Option[LocalDate]
  val endDate: Option[LocalDate]
  val plan: List[TaskStep]

final case class BookTask(
    id: TaskId,
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
) extends Task:
  val taskType: TaskType = Book

final case class ArticleTask(
    id: TaskId,
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
) extends Task:
  val taskType: TaskType = Article

final case class PodcastTask(
    id: TaskId,
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
) extends Task:
  val taskType: TaskType = Podcast

  def duration: FiniteDuration =
    val ms = episodeDuration.toMillis * episodes.value.toLong
    FiniteDuration(ms, MILLISECONDS)
end PodcastTask

final case class VideoTask(
    id: TaskId,
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
) extends Task:
  val taskType: TaskType = Video

final case class CourseTask(
    id: TaskId,
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
) extends Task:
  val taskType: TaskType = Course

final case class UserTask(
    id: TaskId,
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
) extends Task:
  val taskType: TaskType = Custom
