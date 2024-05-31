package api.tech.lab.character.infraestructure.adapter.persistence.repository

import CharacterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CharacterRepository : JpaRepository<CharacterEntity, Long> {
}