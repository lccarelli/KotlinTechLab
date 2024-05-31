package api.tech.lab.notes.application.command.handler

import api.tech.lab.notes.application.command.CreateNoteCommand
import api.tech.lab.notes.domain.event.NoteCreated
import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.domain.model.NoteId
import api.tech.lab.notes.domain.model.NoteState
import api.tech.lab.notes.domain.repository.EventStore

class CreateNoteCommandHandler(private val eventStore: EventStore) {
    fun handle(command: CreateNoteCommand): NoteId {
        val noteId = NoteId()
        val note = Note(
            id = noteId,
            title = command.title,
            content = command.content,
            state = NoteState.PENDING
        )
        eventStore.save(note)
        eventStore.publish(NoteCreated(noteId, command.title, command.content))
        return noteId
    }
}