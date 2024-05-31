package api.tech.lab.board.domain.events

import api.tech.lab.board.domain.model.valueobjects.CardId
import api.tech.lab.board.domain.model.valueobjects.CardStatus

data class CardStatusUpdated(val cardId: CardId, val newStatus: CardStatus) : DomainEvent