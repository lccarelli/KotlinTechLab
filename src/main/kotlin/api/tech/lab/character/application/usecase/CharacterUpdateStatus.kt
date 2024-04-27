package api.tech.lab.character.application.usecase

import api.tech.lab.character.domain.model.Character
import api.tech.lab.character.infraestructure.adapter.persistance.CharacterRepository
import api.tech.lab.character.infraestructure.adapter.persistance.mapper.EntityToDomainMapper
import org.springframework.stereotype.Service
import java.util.*

@Service
class CharacterUpdateStatus(
    private val characterRepository: CharacterRepository,
    private val mapper: EntityToDomainMapper
) {

    fun updateCharacterToDead(id: Long): Optional<Character> {
        return Optional.of(characterRepository.findById(id))
            .filter { it.isPresent }
            .map { it.get() }
            .map { character -> mapper.toDomain(character)}
    }
}