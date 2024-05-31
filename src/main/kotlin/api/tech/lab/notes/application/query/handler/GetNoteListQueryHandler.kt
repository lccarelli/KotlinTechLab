package api.tech.lab.notes.application.query.handler

import api.tech.lab.notes.application.query.GetNoteListQuery
import api.tech.lab.notes.domain.model.Note
import api.tech.lab.notes.infrastructure.repository.ReadModelRepository

class GetNoteListQueryHandler(private val readModelRepository: ReadModelRepository) {
    fun handle(query: GetNoteListQuery): List<Note> {
        return readModelRepository.findAll()
    }
}