package api.tech.lab.board.infrastructure.repositories

import api.tech.lab.board.domain.model.valueobjects.BoardId
import api.tech.lab.board.domain.model.valueobjects.CardId
import api.tech.lab.board.domain.repositories.BoardRepository
import api.tech.lab.board.domain.services.BoardAggregate
import org.springframework.stereotype.Repository

@Repository
class InMemoryBoardRepository : BoardRepository {
    private val boards: MutableList<BoardAggregate> = mutableListOf()

    override fun findById(boardId: BoardId): BoardAggregate? {
        return boards.find { it.board.id == boardId }
    }

    override fun findBoardContainingCard(cardId: CardId): BoardAggregate? {
        return boards.find { boardAggregate ->
            boardAggregate.board.columns.any { column ->
                column.cards.any { card -> card.id == cardId }
            }
        }
    }

    override fun save(boardAggregate: BoardAggregate) {
        val index = boards.indexOfFirst { it.board.id == boardAggregate.board.id }
        if (index >= 0) {
            boards[index] = boardAggregate
        } else {
            boards.add(boardAggregate)
        }
    }
}