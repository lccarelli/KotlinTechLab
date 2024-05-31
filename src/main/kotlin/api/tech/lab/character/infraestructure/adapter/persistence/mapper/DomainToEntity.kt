package api.tech.lab.character.infraestructure.adapter.persistence.mapper

import CharacterEntity
import api.tech.lab.character.domain.model.*

class DomainToEntity : DomainToEntityMapper {
    override fun toEntity(character: Character): CharacterEntity {
        return CharacterEntity(
            id = character.id.toLong(),
            name = character.name,
            status = character.status.type.toString(),
            gender = character.gender.toString() ?: "",
            species = character.species.toString() ?: "",
            origin = character.origin,
            location = character.location,
            image = character.image,
            episodes = character.episodes,
            url = character.url,
            created = character.created,
            updated = character.updated
        )
    }
}