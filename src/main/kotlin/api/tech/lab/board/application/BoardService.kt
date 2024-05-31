package api.tech.lab.board.application

import api.tech.lab.board.application.commands.AddCommentCommand
import api.tech.lab.board.application.commands.MoveCardCommand
import api.tech.lab.board.application.commands.UpdateCardStatusCommand
import api.tech.lab.board.application.commands.handlers.AddCommentCommandHandler
import api.tech.lab.board.application.commands.handlers.MoveCardCommandHandler
import api.tech.lab.board.application.commands.handlers.UpdateCardStatusCommandHandler
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val addCommentCommandHandler: AddCommentCommandHandler,
    private val moveCardCommandHandler: MoveCardCommandHandler,
    private val updateCardStatusCommandHandler: UpdateCardStatusCommandHandler
) {

    fun updateCardStatus(command: UpdateCardStatusCommand) {
        updateCardStatusCommandHandler.handle(command)
    }

    fun addComment(command: AddCommentCommand) {
        addCommentCommandHandler.handle(command)
    }

    fun moveCard(command: MoveCardCommand) {
        moveCardCommandHandler.handle(command)
    }
}
