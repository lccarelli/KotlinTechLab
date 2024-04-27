package api.tech.lab.application.usecase

import api.tech.lab.user.application.port.`in`.CreateUserCommand
import api.tech.lab.user.application.port.out.UserPortOut
import api.tech.lab.user.application.usecase.CreateUserUseCase
import api.tech.lab.user.domain.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CreateUserUseCaseTest {

    private val userPortOut: UserPortOut = mockk(relaxed = true)
    private val createUserUseCase = CreateUserUseCase(userPortOut)

    @Test
    fun `execute should save user and return it`() {
        val command = CreateUserCommand.Command(alias = "testAlias", email = "test@test.com")
        val expectedUser = User(id = 1, alias = "testAlias", email = "test@test.com")

        every { userPortOut.save(any()) } returns expectedUser

        val result = createUserUseCase.execute(command)

        assertEquals(expectedUser, result)
        verify { userPortOut.save(User(alias = command.alias, email = command.email)) }
    }
}
