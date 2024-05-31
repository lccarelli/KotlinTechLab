package api.tech.lab.notes.domain.model

data class NoteId(val value: String = java.util.UUID.randomUUID().toString())