package api.tech.lab.board.application.commands.handlers

import api.tech.lab.board.application.commands.MoveCardCommand
import api.tech.lab.board.domain.model.valueobjects.BoardId
import api.tech.lab.board.domain.repositories.BoardRepository

class MoveCardCommandHandler(private val boardRepository: BoardRepository) {

    fun handle(command: MoveCardCommand) {
        val board = boardRepository.findById(BoardId(command.toString()))
        board?.handle(command)
        boardRepository.save(board!!)
    }
}