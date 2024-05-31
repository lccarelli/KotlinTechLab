package api.tech.lab.board.application.commands

import api.tech.lab.board.domain.model.valueobjects.CardId
import api.tech.lab.board.domain.model.valueobjects.CardStatus

data class UpdateCardStatusCommand(val cardId: CardId, val newStatus: CardStatus)