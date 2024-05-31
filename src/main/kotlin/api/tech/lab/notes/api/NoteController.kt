package api.tech.lab.notes.api

import api.tech.lab.notes.application.command.ChangeNoteStateCommand
import api.tech.lab.notes.application.command.CreateNoteCommand
import api.tech.lab.notes.application.command.DeleteNoteCommand
import api.tech.lab.notes.application.command.handler.ChangeNoteStateCommandHandler
import api.tech.lab.notes.application.command.handler.CreateNoteCommandHandler
import api.tech.lab.notes.application.command.handler.DeleteNoteCommandHandler
import api.tech.lab.notes.application.query.GetNoteListQuery
import api.tech.lab.notes.application.query.GetNoteQuery
import api.tech.lab.notes.application.query.handler.GetNoteListQueryHandler
import api.tech.lab.notes.application.query.handler.GetNoteQueryHandler
import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.domain.model.NoteId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController(
    private val createNoteCommandHandler: CreateNoteCommandHandler,
    private val changeNoteStateCommandHandler: ChangeNoteStateCommandHandler,
    private val deleteNoteCommandHandler: DeleteNoteCommandHandler,
    private val getNoteQueryHandler: GetNoteQueryHandler,
    private val getNoteListQueryHandler: GetNoteListQueryHandler
) {

    @PostMapping
    fun createNote(@RequestBody request: CreateNoteRequest): NoteId {
        return createNoteCommandHandler.handle(CreateNoteCommand(request.title, request.content))
    }

    @PutMapping("/{noteId}/state")
    fun changeNoteState(@PathVariable noteId: String, @RequestBody request: ChangeNoteStateRequest) {
        changeNoteStateCommandHandler.handle(ChangeNoteStateCommand(NoteId(noteId), request.newState))
    }

    @DeleteMapping("/{noteId}")
    fun deleteNote(@PathVariable noteId: String) {
        deleteNoteCommandHandler.handle(DeleteNoteCommand(NoteId(noteId)))
    }

    @GetMapping("/{noteId}")
    fun getNoteById(@PathVariable noteId: String): Note? {
        return getNoteQueryHandler.handle(GetNoteQuery(NoteId(noteId)))
    }

    @GetMapping
    fun getAllNotes(): List<Note> {
        return getNoteListQueryHandler.handle(GetNoteListQuery())
    }
}