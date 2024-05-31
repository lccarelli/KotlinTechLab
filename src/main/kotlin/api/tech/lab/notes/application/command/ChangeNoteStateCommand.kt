package api.tech.lab.notes.application.command

import api.tech.lab.notes.domain.model.NoteId
import api.tech.lab.notes.domain.model.NoteState

data class ChangeNoteStateCommand(val noteId: NoteId, val newState: NoteState)