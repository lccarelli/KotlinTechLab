package api.tech.lab.notes.infrastructure.config

import api.tech.lab.notes.application.command.handler.ChangeNoteStateCommandHandler
import api.tech.lab.notes.application.command.handler.CreateNoteCommandHandler
import api.tech.lab.notes.application.command.handler.DeleteNoteCommandHandler
import api.tech.lab.notes.application.query.handler.GetNoteListQueryHandler
import api.tech.lab.notes.application.query.handler.GetNoteQueryHandler
import api.tech.lab.notes.domain.repository.EventStore
import api.tech.lab.notes.infrastructure.persistence.ReadModelRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun createNoteCommandHandler(eventStore: EventStore): CreateNoteCommandHandler {
        return CreateNoteCommandHandler(eventStore)
    }

    @Bean
    fun changeNoteStateCommandHandler(eventStore: EventStore): ChangeNoteStateCommandHandler {
        return ChangeNoteStateCommandHandler(eventStore)
    }

    @Bean
    fun deleteNoteCommandHandler(eventStore: EventStore): DeleteNoteCommandHandler {
        return DeleteNoteCommandHandler(eventStore)
    }

    @Bean
    fun getNoteQueryHandler(readModelRepository: ReadModelRepositoryImpl): GetNoteQueryHandler {
        return GetNoteQueryHandler(readModelRepository)
    }

    @Bean
    fun getNoteListQueryHandler(readModelRepository: ReadModelRepositoryImpl): GetNoteListQueryHandler {
        return GetNoteListQueryHandler(readModelRepository)
    }
}