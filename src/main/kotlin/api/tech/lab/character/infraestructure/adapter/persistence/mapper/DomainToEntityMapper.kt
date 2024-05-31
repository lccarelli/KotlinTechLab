package api.tech.lab.character.infraestructure.adapter.persistence.mapper

import CharacterEntity
import api.tech.lab.character.domain.model.Character as Character

interface DomainToEntityMapper {
    fun toEntity(character: Character): CharacterEntity
}