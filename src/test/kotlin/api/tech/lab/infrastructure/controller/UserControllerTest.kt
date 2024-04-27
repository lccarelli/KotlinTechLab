package api.tech.lab.infrastructure.controller

import api.tech.lab.user.application.port.`in`.CreateUserCommand
import api.tech.lab.user.domain.User
import api.tech.lab.user.infrastructure.controller.model.CreateUserModel
import api.tech.lab.user.infrastructure.controller.model.UserResponseModel
import api.tech.lab.user.infrastructure.controller.UserController
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class UserControllerTest {

    private val createUserCommand: CreateUserCommand = mockk(relaxed = true)
    private val userController = UserController(createUserCommand)

    @Test
    fun `createUser should return created user`() {
        val createUserModel = CreateUserModel(alias = "testAlias", email = "test@test.com")
        val expectedUser = User(id=1, alias = "testAlias", email = "test@test.com")
        val expectedResponse = ResponseEntity(UserResponseModel.from(expectedUser), HttpStatus.CREATED)

        every { createUserCommand.execute(any()) } returns expectedUser

        val response = userController.createUser(createUserModel)

        assertEquals(expectedResponse.statusCode, response.statusCode)
        assertEquals(expectedResponse.body, response.body)
        verify { createUserCommand.execute(createUserModel.toCommand()) }
    }
}
