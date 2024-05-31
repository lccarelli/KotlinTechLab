package api.tech.lab.notes.infrastructure.persistence

import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.domain.model.NoteId
import api.tech.lab.notes.infrastructure.repository.ReadModelRepository
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class ReadModelRepositoryImpl : ReadModelRepository {
    val notes = ConcurrentHashMap<NoteId, Note>()

    override fun findById(noteId: NoteId): Note? {
        return notes[noteId]
    }

    override fun findAll(): List<Note> {
        return notes.values.toList()
    }
}