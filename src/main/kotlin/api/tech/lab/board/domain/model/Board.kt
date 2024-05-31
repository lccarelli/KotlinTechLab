package api.tech.lab.board.domain.model

import api.tech.lab.board.domain.model.valueobjects.BoardId
import api.tech.lab.board.domain.model.valueobjects.BoardName
import api.tech.lab.board.domain.model.valueobjects.CardId
import api.tech.lab.board.domain.model.valueobjects.ColumnId

data class Board(
    val id: BoardId,
    val name: BoardName,
    val columns: MutableList<Column> = mutableListOf()
) {
    fun addColumn(column: Column) {
        this.columns.add(column)
    }

    fun moveCard(cardId: CardId, targetColumnId: ColumnId) {
        val card = columns.flatMap { it.cards }.find { it.id == cardId }
        val currentColumn = columns.find { it.cards.contains(card) }
        val targetColumn = columns.find { it.id == targetColumnId }

        if (card != null && currentColumn != null && targetColumn != null) {
            currentColumn.removeCard(cardId)
            targetColumn.addCard(card)
        }
    }
}