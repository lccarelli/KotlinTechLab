package api.tech.lab.board.domain.model

import api.tech.lab.board.domain.events.CardStatusUpdated
import api.tech.lab.board.domain.events.CommentAdded
import api.tech.lab.board.domain.model.valueobjects.CardDescription
import api.tech.lab.board.domain.model.valueobjects.CardId
import api.tech.lab.board.domain.model.valueobjects.CardStatus
import api.tech.lab.board.domain.model.valueobjects.CardTitle
import api.tech.lab.board.infrastructure.eventstore.DomainEvents

data class Card(
    val id: CardId,
    var title: CardTitle,
    var description: CardDescription,
    var status: CardStatus,
    val comments: MutableList<Comment> = mutableListOf()
) {
    fun updateStatus(newStatus: CardStatus) {
        this.status = newStatus
        DomainEvents.raise(CardStatusUpdated(this.id, newStatus))
    }

    fun addComment(comment: Comment) {
        this.comments.add(comment)
        DomainEvents.raise(CommentAdded(this.id, comment))
    }
}