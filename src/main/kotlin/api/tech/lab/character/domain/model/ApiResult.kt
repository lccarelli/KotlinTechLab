package api.tech.lab.character.domain.model

data class ApiResult(
    val info: PageInfo,
    val results: List<Character>
)

data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class Location(
    val name: String,
    val url: String
)
