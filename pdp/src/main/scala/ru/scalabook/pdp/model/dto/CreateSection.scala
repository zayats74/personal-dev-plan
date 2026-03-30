package ru.scalabook.pdp.model.dto

import ru.scalabook.pdp.model.{Ordinal, UserId}
import ru.scalabook.pdp.model.entity.Section.*

final case class CreateSection(
    name: SectionName,
    userId: UserId,
    displayed: Boolean,
    ordinal: Ordinal
)
