package api.tech.lab.board.domain.events

import api.tech.lab.board.domain.model.Comment
import api.tech.lab.board.domain.model.valueobjects.CardId

data class CommentAdded(val cardId: CardId, val comment: Comment) : DomainEvent