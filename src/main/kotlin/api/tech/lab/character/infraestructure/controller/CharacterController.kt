package api.tech.lab.character.infraestructure.controller

import api.tech.lab.character.application.usecase.CharacterUpdateStatus
import api.tech.lab.character.domain.model.ApiResult
import api.tech.lab.character.domain.model.Character
import api.tech.lab.character.infraestructure.adapter.client.RickAndMortyClient
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("api/v1/characters")
class CharacterController(private val characterUpdateStatus: CharacterUpdateStatus) {

    @RestController
    class CharacterController(private val rickAndMortyClient: RickAndMortyClient) {

        @GetMapping("/")
        fun listCharacters(): Mono<ApiResult> {
            return rickAndMortyClient.getCharacters()
        }
    }

    @PostMapping("/{id}/updateToDead")
    fun updateStatusToDead(@PathVariable id: Long): Optional<Character> {
        return characterUpdateStatus.updateCharacterToDead(id)
    }
}

