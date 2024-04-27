package api.tech.lab.character.infraestructure.adapter.persistance.mapper

import CharacterEntity
import api.tech.lab.character.domain.model.*

interface EntityToDomainMapper {
    fun toDomain(entity: CharacterEntity): Character
}