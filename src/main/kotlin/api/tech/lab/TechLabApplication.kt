package api.tech.lab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["api.tech.lab.character.infraestructure.adapter.persistence.repository"])
@EntityScan("api.tech.lab.character.infraestructure.adapter.persistence.model")
class TechLabApplication

fun main(args: Array<String>) {
	runApplication<TechLabApplication>(*args)
}
