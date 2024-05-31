package api.tech.lab.board.api.dtos

data class ColumnDto(
    val name: String,
    val cards: List<CardDto>
)