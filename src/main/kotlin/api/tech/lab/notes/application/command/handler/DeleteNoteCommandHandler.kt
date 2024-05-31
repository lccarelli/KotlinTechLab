package api.tech.lab.notes.application.command.handler

import api.tech.lab.notes.application.command.DeleteNoteCommand
import api.tech.lab.notes.domain.event.NoteDeleted
import api.tech.lab.notes.domain.repository.EventStore

class DeleteNoteCommandHandler(private val eventStore: EventStore) {
    fun handle(command: DeleteNoteCommand) {
        val note = eventStore.load(command.noteId)
            ?: throw IllegalArgumentException("Note not found")
        note.delete()
        eventStore.save(note)
        eventStore.publish(NoteDeleted(command.noteId))
    }
}