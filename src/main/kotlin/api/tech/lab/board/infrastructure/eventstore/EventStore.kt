package api.tech.lab.board.infrastructure.eventstore

import api.tech.lab.board.domain.events.DomainEvent

object EventStore {
    private val events: MutableList<DomainEvent> = mutableListOf()

    fun append(event: DomainEvent) {
        events.add(event)
    }

    fun getEvents(): List<DomainEvent> {
        return events.toList()
    }
}