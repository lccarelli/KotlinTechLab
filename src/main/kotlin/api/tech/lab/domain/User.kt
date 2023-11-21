package api.tech.lab.domain

data class User(
    val id: Int? = null,
    val alias: String,
    val email: String,
)