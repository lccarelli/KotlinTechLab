package api.tech.lab.notes.domain.repository

import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.domain.model.NoteId

interface EventStore {
    fun save(note: Note)
    fun load(noteId: NoteId): Note?
    fun publish(event: Any)
}