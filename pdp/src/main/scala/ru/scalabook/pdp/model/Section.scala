package ru.scalabook.pdp.model

import io.github.iltotore.iron.RefinedType
import io.github.iltotore.iron.constraint.all.{MaxLength, MinLength, Trimmed}
import io.github.iltotore.iron.constraint.numeric.GreaterEqual
import ru.scalabook.pdp.model.Section.*

final case class Section(
    id: SectionId,
    name: SectionName,
    userId: UserId,
    displayed: Boolean,
    ordinal: Ordinal
)

object Section:
  type SectionId = SectionId.T
  object SectionId extends RefinedType[Int, GreaterEqual[0]]

  type SectionName = SectionName.T
  object SectionName
      extends RefinedType[String, MinLength[2] & MaxLength[100] & Trimmed]
