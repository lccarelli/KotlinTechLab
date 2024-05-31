package api.tech.lab.character.application.usecase

import CharacterEntity
import api.tech.lab.character.domain.model.Character
import api.tech.lab.character.infraestructure.adapter.persistence.repository.CharacterRepository
import api.tech.lab.character.infraestructure.adapter.persistence.mapper.EntityToDomainMapper
import org.springframework.stereotype.Component
import java.util.*

@Component
class CharacterUpdateStatus(
    private val characterRepository: CharacterRepository,
    private val mapper: EntityToDomainMapper
) {

    fun updateCharacterToDead(id: Long): Optional<Character> {

        val characterEntity:Optional<CharacterEntity> = characterRepository.findById(id);
        if(characterEntity.isPresent.not()) {
            return Optional.empty()
        }

        val domain: Character = mapper.toDomain(characterEntity.get())

        val domainUpdated: Character = domain.copy(status = domain.status.transitionToDead())

        val entityToUpdate: CharacterEntity = mapper.toEntity(domainUpdated)

        val updatedEntity = characterRepository.save(entityToUpdate)

        return mapper.toDomain(updatedEntity).let { Optional.of(it) }

    }
}