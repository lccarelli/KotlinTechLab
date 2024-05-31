package api.tech.lab.board.domain.repositories

import api.tech.lab.board.domain.services.BoardAggregate
import api.tech.lab.board.domain.model.valueobjects.BoardId
import api.tech.lab.board.domain.model.valueobjects.CardId

interface BoardRepository {
    fun findById(boardId: BoardId): BoardAggregate?
    fun findBoardContainingCard(cardId: CardId): BoardAggregate?
    fun save(boardAggregate: BoardAggregate)
}
