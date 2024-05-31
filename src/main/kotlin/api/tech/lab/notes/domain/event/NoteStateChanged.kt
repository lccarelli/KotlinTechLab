package api.tech.lab.notes.domain.event

import api.tech.lab.notes.domain.model.NoteId
import api.tech.lab.notes.domain.model.NoteState
import java.time.LocalDateTime

data class NoteStateChanged(
    val noteId: NoteId,
    val newState: NoteState,
    val occurredAt: LocalDateTime = LocalDateTime.now()
)