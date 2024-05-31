package api.tech.lab.board.api.dtos

data class CardDto(
    val title: String,
    val description: String,
    val status: String,
    val comments: List<CommentDto>
)