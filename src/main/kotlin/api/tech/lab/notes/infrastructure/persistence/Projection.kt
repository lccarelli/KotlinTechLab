package api.tech.lab.notes.infrastructure.persistence

import api.tech.lab.notes.domain.event.NoteCreated
import api.tech.lab.notes.domain.event.NoteDeleted
import api.tech.lab.notes.domain.event.NoteStateChanged
import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.domain.model.NoteState
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class Projection(private val readModelRepository: ReadModelRepositoryImpl) {

    @EventListener
    fun on(noteCreated: NoteCreated) {
        val note = Note(
            id = noteCreated.noteId,
            title = noteCreated.title,
            content = noteCreated.content,
            state = NoteState.PENDING
        )
        readModelRepository.notes[noteCreated.noteId] = note
    }

    @EventListener
    fun on(noteStateChanged: NoteStateChanged) {
        val note = readModelRepository.notes[noteStateChanged.noteId]
        note?.changeState(noteStateChanged.newState)
        note?.let { readModelRepository.notes[noteStateChanged.noteId] = it }
    }

    @EventListener
    fun on(noteDeleted: NoteDeleted) {
        val note = readModelRepository.notes[noteDeleted.noteId]
        note?.delete()
        note?.let { readModelRepository.notes[noteDeleted.noteId] = it }
    }
}