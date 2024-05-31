package api.tech.lab.board.application.commands

import api.tech.lab.board.api.dtos.CardDto
import api.tech.lab.board.api.dtos.UserDto
import api.tech.lab.board.domain.model.User
import api.tech.lab.board.domain.model.valueobjects.CardId

data class AddCommentCommand(val cardId: CardId, val content: String, val author: User)