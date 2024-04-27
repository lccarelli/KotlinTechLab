package api.tech.lab.character.infraestructure.adapter.persistance.mapper

import CharacterEntity
import api.tech.lab.character.domain.model.*

class EntityToDomain : EntityToDomainMapper {
    override fun toDomain(entity: CharacterEntity): Character {
        return Character(
            id = entity.id!!,
            name = entity.name,
            status = Status.from(entity.status),
            gender = Gender.from(entity.gender),
            species = Species.from(entity.species),
            origin = entity.origin,
            location = entity.location,
            image = entity.image,
            episodes = entity.episodes,
            url = entity.url,
            created = entity.created,
            updated = entity.updated
        )
    }
}