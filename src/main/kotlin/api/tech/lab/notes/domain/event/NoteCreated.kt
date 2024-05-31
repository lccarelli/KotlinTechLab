package api.tech.lab.notes.domain.event

import api.tech.lab.notes.domain.model.NoteId
import java.time.LocalDateTime

data class NoteCreated(
    val noteId: NoteId,
    val title: String,
    val content: String,
    val occurredAt: LocalDateTime = LocalDateTime.now()
)