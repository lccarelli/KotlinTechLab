package api.tech.lab.character.infraestructure.adapter.persistance.mapper

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MapperConfig {
    @Bean
    fun entityToDomainMapper(): EntityToDomainMapper = EntityToDomain()

    @Bean
    fun domainToEntityMapper(): DomainToEntityMapper = DomainToEntity()
}