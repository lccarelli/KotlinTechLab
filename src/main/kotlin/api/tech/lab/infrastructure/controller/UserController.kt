package api.tech.lab.infrastructure.controller

import api.tech.lab.infrastructure.controller.model.CreateUserModel
import api.tech.lab.infrastructure.controller.model.UserResponseModel
import api.tech.lab.application.port.`in`.CreateUserCommand
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
class UserController(
    private val createUser: CreateUserCommand,
) {
    @PostMapping
    fun createUser(@RequestBody request: CreateUserModel): ResponseEntity<UserResponseModel> = request
        .also { logger.info("Attempt to create user with request {}", it) }
        .let { createUser.execute(it.toCommand()) }
        .let { user -> UserResponseModel.from(user) }
        .let { controllerModel -> ResponseEntity(controllerModel, HttpStatus.CREATED) }
        .also { response -> logger.info("User created successfully: {}", response) }


    private fun CreateUserModel.toCommand(): CreateUserCommand.Command = api.tech.lab.application.port.`in`.CreateUserCommand.Command(
        alias = this.alias,
        email = this.email
    )

    companion object {
        @JvmStatic
        private val logger: Logger = LoggerFactory.getLogger(UserController::class.java)
    }
}