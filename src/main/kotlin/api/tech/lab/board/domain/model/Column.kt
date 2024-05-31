package api.tech.lab.board.domain.model

import api.tech.lab.board.domain.model.valueobjects.CardId
import api.tech.lab.board.domain.model.valueobjects.ColumnId
import api.tech.lab.board.domain.model.valueobjects.ColumnName

data class Column(
    val id: ColumnId,
    val name: ColumnName,
    val cards: MutableList<Card> = mutableListOf()
) {
    fun addCard(card: Card) {
        this.cards.add(card)
    }

    fun removeCard(cardId: CardId) {
        this.cards.removeIf { it.id == cardId }
    }
}