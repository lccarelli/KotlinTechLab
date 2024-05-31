package api.tech.lab.board.infrastructure.eventstore

import api.tech.lab.board.domain.events.DomainEvent

object DomainEvents {
    private val handlers: MutableList<(DomainEvent) -> Unit> = mutableListOf()

    fun register(handler: (DomainEvent) -> Unit) {
        handlers.add(handler)
    }

    fun raise(event: DomainEvent) {
        EventStore.append(event)
        handlers.forEach { it(event) }
    }
}