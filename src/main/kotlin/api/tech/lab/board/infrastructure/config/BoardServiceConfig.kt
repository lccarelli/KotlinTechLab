package api.tech.lab.board.infrastructure.config

import api.tech.lab.board.application.BoardService
import api.tech.lab.board.application.commands.handlers.AddCommentCommandHandler
import api.tech.lab.board.application.commands.handlers.MoveCardCommandHandler
import api.tech.lab.board.application.commands.handlers.UpdateCardStatusCommandHandler
import api.tech.lab.board.domain.repositories.BoardRepository
import api.tech.lab.board.infrastructure.repositories.InMemoryBoardRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BoardServiceConfig {

    @Bean
    fun boardService(
        addCommentCommandHandler: AddCommentCommandHandler,
        moveCardCommandHandler: MoveCardCommandHandler,
        updateCardStatusCommandHandler: UpdateCardStatusCommandHandler
    ): BoardService {
        return BoardService(addCommentCommandHandler, moveCardCommandHandler, updateCardStatusCommandHandler)
    }

    @Bean
    fun addCommentCommandHandler(boardRepository: BoardRepository): AddCommentCommandHandler {
        return AddCommentCommandHandler(boardRepository)
    }

    @Bean
    fun moveCardCommandHandler(boardRepository: BoardRepository): MoveCardCommandHandler {
        return MoveCardCommandHandler(boardRepository)
    }

    @Bean
    fun updateCardStatusCommandHandler(boardRepository: BoardRepository): UpdateCardStatusCommandHandler {
        return UpdateCardStatusCommandHandler(boardRepository)
    }

    @Bean
    fun boardRepository(): BoardRepository {
        return InMemoryBoardRepository()
    }
}