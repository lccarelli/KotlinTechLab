package api.tech.lab.board.api.dtos

import java.time.LocalDateTime

data class CommentDto(
    val content: String,
    val author: UserDto,
    val timestamp: LocalDateTime
)