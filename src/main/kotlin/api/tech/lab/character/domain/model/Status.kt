package api.tech.lab.character.domain.model

import java.time.LocalDate

data class Status constructor(val type: Type, val createdAt: LocalDate) {
    companion object {
        fun from(value: String?): Status = when(value?.toLowerCase()) {
            "alive" -> Status(Type.ALIVE, LocalDate.now())
            "dead" -> Status(Type.DEAD, LocalDate.now())
            null, "unknown" -> Status(Type.UNKNOWN, LocalDate.now())
            else -> throw IllegalArgumentException("Invalid gender value: $value")
        }
    }
    /**
     * Transitions the current status to DEAD if the current status is ALIVE.
     *
     * @param currentStatus the current status of the object.
     * @return a new Status instance representing the DEAD state with the current date.
     * @throws InvalidStatusTransitionException if the current status is not ALIVE,
     *         indicating that a transition to DEAD is not permitted from the current state.
     */
    fun transitionToDead(): Status {
        if (this.type != Type.ALIVE) {
            throw InvalidStatusTransitionException("Transition only allowed from ALIVE to DEAD.")
        }
        return Status(Type.DEAD, LocalDate.now())
    }
}

enum class Type {
    ALIVE, DEAD, UNKNOWN
}


class InvalidStatusTransitionException(message: String) : Exception(message)