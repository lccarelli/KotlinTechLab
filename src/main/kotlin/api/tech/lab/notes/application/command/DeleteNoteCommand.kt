package api.tech.lab.notes.application.command

import api.tech.lab.notes.domain.model.NoteId

data class DeleteNoteCommand(val noteId: NoteId)