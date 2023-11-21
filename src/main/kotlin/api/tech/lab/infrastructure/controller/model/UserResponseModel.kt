package api.tech.lab.infrastructure.controller.model

import api.tech.lab.domain.User
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserResponseModel (
    val id: Int,
    val alias: String,
    val email: String,
){
    companion object {
        fun from(domain: User): UserResponseModel = UserResponseModel(
            id = domain.id!!,
            alias = domain.alias,
            email = domain.email,
        )
    }
}