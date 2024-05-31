package api.tech.lab.notes.infrastructure.repository

import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.domain.model.NoteId

interface ReadModelRepository {
    fun findById(noteId: NoteId): Note?
    fun findAll(): List<Note>
}