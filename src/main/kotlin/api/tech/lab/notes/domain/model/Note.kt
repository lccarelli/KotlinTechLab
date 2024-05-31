package api.tech.lab.notes.domain.model

import java.time.LocalDateTime

data class Note(
    val id: NoteId,
    var title: String,
    var content: String,
    var state: NoteState,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun changeState(newState: NoteState) {
        this.state = newState
    }

    fun delete() {
        this.state = NoteState.DELETED
    }
}
