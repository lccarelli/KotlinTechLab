package api.tech.lab.application.port.out

import api.tech.lab.domain.User

interface UserPortOut {
    fun save(user: User): User
}