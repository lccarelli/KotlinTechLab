package api.tech.lab.character.domain.model

import lombok.Builder
import java.time.LocalDate

@Builder
data class Character(
    val id: Long,
    val name: String,
    val status: Status,
    val gender: Gender?,
    val species: Species?,
    val origin: String,
    val location: String,
    val image: String,
    val episodes: List<String>,
    val url: String,
    val created: LocalDate,
    val updated: LocalDate
)