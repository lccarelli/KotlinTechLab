package api.tech.lab.board.api.dtos

data class BoardDto(
    val name: String,
    val columns: List<ColumnDto>
)