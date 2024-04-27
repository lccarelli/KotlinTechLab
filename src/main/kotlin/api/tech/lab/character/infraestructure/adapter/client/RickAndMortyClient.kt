package api.tech.lab.character.infraestructure.adapter.client

import api.tech.lab.character.domain.model.ApiResult
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class RickAndMortyClient(
    @Value("\${rickandmorty.api.baseurl}") private val baseUrl: String,
    private var webClient: WebClient
) {
    init {
        webClient = WebClient.builder().baseUrl(baseUrl).build()
    }

    fun getCharacters(): Mono<ApiResult> {
        return webClient.get()
            .uri("/character")
            .retrieve()
            .bodyToMono(ApiResult::class.java)
    }
}