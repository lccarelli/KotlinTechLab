package api.tech.lab.notes.domain.event

import api.tech.lab.notes.domain.model.NoteId
import java.time.LocalDateTime

data class NoteDeleted(
    val noteId: NoteId,
    val occurredAt: LocalDateTime = LocalDateTime.now()
)