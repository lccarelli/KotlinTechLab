package api.tech.lab.application.port.`in`

import api.tech.lab.domain.User

interface CreateUserCommand {

    fun execute(command: Command): User

    data class Command(
        val alias: String,
        val email: String,
    )
}