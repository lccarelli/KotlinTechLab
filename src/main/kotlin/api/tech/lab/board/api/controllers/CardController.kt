package api.tech.lab.board.api.controllers

import api.tech.lab.board.api.dtos.AddCommentDto
import api.tech.lab.board.api.dtos.MoveCardDto
import api.tech.lab.board.api.dtos.UpdateCardStatusDto
import api.tech.lab.board.application.BoardService
import api.tech.lab.board.application.commands.AddCommentCommand
import api.tech.lab.board.application.commands.MoveCardCommand
import api.tech.lab.board.application.commands.UpdateCardStatusCommand
import api.tech.lab.board.domain.model.User
import api.tech.lab.board.domain.model.valueobjects.CardId
import api.tech.lab.board.domain.model.valueobjects.CardStatus
import api.tech.lab.board.domain.model.valueobjects.ColumnId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cards")
class CardController(private val boardService: BoardService) {

    @PatchMapping("/{cardId}/status")
    fun updateCardStatus(@PathVariable cardId: String, @RequestBody updateCardStatusDto: UpdateCardStatusDto): ResponseEntity<Void> {
        val command = UpdateCardStatusCommand(CardId(cardId), CardStatus(updateCardStatusDto.status))
        boardService.updateCardStatus(command)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/{cardId}/comments")
    fun addComment(@PathVariable cardId: String, @RequestBody addCommentDto: AddCommentDto): ResponseEntity<Void> {
        val command = AddCommentCommand(CardId(cardId), addCommentDto.content, User(addCommentDto.author))
        boardService.addComment(command)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PostMapping("/{cardId}/move")
    fun moveCard(@PathVariable cardId: String, @RequestBody moveCardDto: MoveCardDto): ResponseEntity<Void> {
        val command = MoveCardCommand(CardId(cardId), ColumnId(moveCardDto.targetColumnId))
        boardService.moveCard(command)
        return ResponseEntity.ok().build()
    }
}

