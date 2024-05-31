package api.tech.lab.notes.application.query

import api.tech.lab.notes.domain.model.NoteId

data class GetNoteQuery(val noteId: NoteId)