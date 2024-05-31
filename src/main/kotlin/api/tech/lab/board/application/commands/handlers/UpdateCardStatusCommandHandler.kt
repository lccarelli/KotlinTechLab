package api.tech.lab.board.application.commands.handlers

import api.tech.lab.board.application.commands.UpdateCardStatusCommand
import api.tech.lab.board.domain.model.valueobjects.CardStatus
import api.tech.lab.board.domain.repositories.BoardRepository

class UpdateCardStatusCommandHandler(private val boardRepository: BoardRepository) {

    fun handle(command: UpdateCardStatusCommand) {
        val board = boardRepository.findBoardContainingCard(command.cardId)
        val status = CardStatus(command.newStatus.value)
        board?.handle(command.copy(newStatus = status))
        boardRepository.save(board!!)
    }
}