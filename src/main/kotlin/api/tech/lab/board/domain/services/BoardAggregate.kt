package api.tech.lab.board.domain.services

import api.tech.lab.board.application.commands.AddCommentCommand
import api.tech.lab.board.application.commands.MoveCardCommand
import api.tech.lab.board.application.commands.UpdateCardStatusCommand
import api.tech.lab.board.domain.model.Board
import api.tech.lab.board.domain.model.Comment
import api.tech.lab.board.domain.model.valueobjects.CommentContent
import api.tech.lab.board.domain.model.valueobjects.CommentId
import java.util.*

class BoardAggregate(val board: Board) {
    fun handle(command: UpdateCardStatusCommand) {
        val card = board.columns.flatMap { it.cards }.find { it.id == command.cardId }
        card?.updateStatus(command.newStatus)
        // persist changes and raise events
    }

    fun handle(command: AddCommentCommand) {
        val card = board.columns.flatMap { it.cards }.find { it.id == command.cardId }
        val comment = Comment(CommentId(UUID.randomUUID().toString()), CommentContent(command.content), command.author)
        card?.addComment(comment)
        // persist changes and raise events
    }

    fun handle(command: MoveCardCommand) {
        board.moveCard(command.cardId, command.targetColumnId)
        // persist changes and raise events
    }
}
