package api.tech.lab.notes.infrastructure.repository

import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.domain.model.NoteId
import api.tech.lab.notes.domain.repository.EventStore
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class EventStoreImpl : EventStore {
    private val notes = ConcurrentHashMap<NoteId, Note>()
    private val events = mutableListOf<Any>()

    override fun save(note: Note) {
        notes[note.id] = note
    }

    override fun load(noteId: NoteId): Note? {
        return notes[noteId]
    }

    override fun publish(event: Any) {
        events.add(event)
        // todo: publicar a los interesados
    }
}