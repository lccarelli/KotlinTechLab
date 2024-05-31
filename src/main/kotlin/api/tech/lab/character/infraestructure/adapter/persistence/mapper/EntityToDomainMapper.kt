package api.tech.lab.character.infraestructure.adapter.persistence.mapper

import CharacterEntity
import api.tech.lab.character.domain.model.*

@FunctionalInterface
interface EntityToDomainMapper {
    fun toDomain(entity: CharacterEntity): Character
    fun toEntity(domain: Character): CharacterEntity
}