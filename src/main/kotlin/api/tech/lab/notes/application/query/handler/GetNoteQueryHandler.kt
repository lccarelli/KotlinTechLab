package api.tech.lab.notes.application.query.handler

import api.tech.lab.notes.application.query.GetNoteQuery
import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.infrastructure.repository.ReadModelRepository

class GetNoteQueryHandler(private val readModelRepository: ReadModelRepository) {
    fun handle(query: GetNoteQuery): Note? {
        return readModelRepository.findById(query.noteId)
    }
}