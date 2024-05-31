package api.tech.lab.board.application.commands

import api.tech.lab.board.domain.model.valueobjects.CardId
import api.tech.lab.board.domain.model.valueobjects.ColumnId

data class MoveCardCommand(val cardId: CardId, val targetColumnId: ColumnId)