package api.tech.lab.notes.api

import api.tech.lab.notes.domain.model.NoteState

data class ChangeNoteStateRequest(val newState: NoteState)