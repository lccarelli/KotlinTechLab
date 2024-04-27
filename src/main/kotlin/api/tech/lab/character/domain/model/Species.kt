package api.tech.lab.character.domain.model

enum class Species {
    HUMAN, ANDROID, ANIMAL, UNKNOWN;

    companion object {
        fun from(value: String?): Species = when(value?.toLowerCase()) {
            "human" -> HUMAN
            "android" -> ANDROID
            "animal" -> ANIMAL
            null -> UNKNOWN
            else -> throw IllegalArgumentException("Invalid species value: $value")
        }
    }
}
