package api.tech.lab.character.infraestructure.adapter.persistence.mapper

import CharacterEntity
import api.tech.lab.character.domain.model.*
import java.time.LocalDate

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

    override fun toEntity(domain: Character): CharacterEntity {
        return CharacterEntity(
            id = domain.id,
            name = domain.name,
            status = domain.status.toString(),
            gender = domain.gender.toString(),
            species = domain.species.toString(),
            origin = domain.origin,
            location = domain.location,
            image = domain.image,
            episodes = domain.episodes,
            url = domain.url,
            created = domain.created,
            updated = LocalDate.now()
        )
    }
}