package api.tech.lab.board.domain.model

import api.tech.lab.board.domain.model.valueobjects.CommentContent
import api.tech.lab.board.domain.model.valueobjects.CommentId
import java.time.LocalDateTime

data class Comment(
    val id: CommentId,
    val content: CommentContent,
    val author: User,
    val timestamp: LocalDateTime = LocalDateTime.now()
)