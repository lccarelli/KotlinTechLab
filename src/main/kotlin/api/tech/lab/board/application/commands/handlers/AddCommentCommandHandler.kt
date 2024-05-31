package api.tech.lab.board.application.commands.handlers

import api.tech.lab.board.application.commands.AddCommentCommand
import api.tech.lab.board.domain.model.Comment
import api.tech.lab.board.domain.model.valueobjects.CommentContent
import api.tech.lab.board.domain.model.valueobjects.CommentId
import api.tech.lab.board.domain.repositories.BoardRepository
import java.util.*

class AddCommentCommandHandler(private val boardRepository: BoardRepository) {

    fun handle(command: AddCommentCommand) {
        val board = boardRepository.findBoardContainingCard(command.cardId)
        val comment = Comment(CommentId(UUID.randomUUID().toString()), CommentContent(command.content), command.author)
        board?.handle(command.copy())
        boardRepository.save(board!!)
    }
}