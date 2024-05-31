package api.tech.lab.board.api.controllers

import api.tech.lab.board.api.dtos.BoardDto
import api.tech.lab.board.application.BoardService
import api.tech.lab.board.domain.model.Board
import api.tech.lab.board.domain.model.valueobjects.BoardId
import api.tech.lab.board.domain.model.valueobjects.BoardName
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/boards")
class BoardController(private val boardService: BoardService) {

    @PostMapping
    fun createBoard(@RequestBody boardDto: BoardDto): ResponseEntity<BoardDto> {
        val board = Board(BoardId(UUID.randomUUID().toString()), BoardName(boardDto.name))
        // Save board and return response
        return ResponseEntity.status(HttpStatus.CREATED).body(boardDto)
    }
}
