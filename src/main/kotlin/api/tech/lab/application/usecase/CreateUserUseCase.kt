package api.tech.lab.application.usecase

import api.tech.lab.application.port.`in`.CreateUserCommand
import api.tech.lab.application.port.out.UserPortOut
import api.tech.lab.domain.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CreateUserUseCase (
    private val userPortOut: UserPortOut,
): CreateUserCommand {

    override fun execute(command: CreateUserCommand.Command): User {
        logger.info("command {}", command)
        val user = command.toDomain()
        logger.info("user domain {}", user)
        val userSaved = userPortOut.save(user)
        return userSaved
    }

    private fun CreateUserCommand.Command.toDomain(): User = User(
        alias = this.alias,
        email = this.email,
    )

    companion object {
        @JvmStatic
        private val logger: Logger = LoggerFactory.getLogger(CreateUserUseCase::class.java)
    }
}