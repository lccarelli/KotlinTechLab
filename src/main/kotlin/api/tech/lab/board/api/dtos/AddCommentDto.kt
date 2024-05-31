package api.tech.lab.board.api.dtos

data class AddCommentDto(
    val content: String,
    val author: UserDto
)