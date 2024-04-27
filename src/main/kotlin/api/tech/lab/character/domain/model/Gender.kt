package api.tech.lab.character.domain.model

enum class Gender {
    FEMALE, MALE, GENDERLESS, UNKNOWN;

    companion object {
        fun from(value: String?): Gender = when(value?.toLowerCase()) {
            "female" -> FEMALE
            "male" -> MALE
            "genderless" -> GENDERLESS
            null, "unknown" -> UNKNOWN
            else -> throw IllegalArgumentException("Invalid gender value: $value")
        }
    }
}