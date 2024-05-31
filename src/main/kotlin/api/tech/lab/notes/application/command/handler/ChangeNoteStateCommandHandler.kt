package api.tech.lab.notes.application.command.handler

import api.tech.lab.notes.application.command.ChangeNoteStateCommand
import api.tech.lab.notes.domain.event.NoteStateChanged
import api.tech.lab.notes.domain.repository.EventStore

class ChangeNoteStateCommandHandler(private val eventStore: EventStore) {
    fun handle(command: ChangeNoteStateCommand) {
        val note = eventStore.load(command.noteId)
            ?: throw IllegalArgumentException("Note not found")
        note.changeState(command.newState)
        eventStore.save(note)
        eventStore.publish(NoteStateChanged(command.noteId, command.newState))
    }
}