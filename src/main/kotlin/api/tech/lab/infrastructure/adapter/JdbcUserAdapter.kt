package api.tech.lab.infrastructure.adapter

import api.tech.lab.application.port.out.UserPortOut
import api.tech.lab.domain.User
import api.tech.lab.infrastructure.adapter.model.UserEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Component
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.Statement

@Component
class JdbcUserAdapter(private val jdbcTemplate: JdbcTemplate): UserPortOut {

    override fun save(user: User): User {
        logger.info("[JdbcUserAdapter]: Saving User: {}", user)

        val keyHolder = GeneratedKeyHolder()

        try {
            jdbcTemplate.update({ connection ->
                createPreparedStatementForInsert(connection, user.toEntity())
            }, keyHolder)

            val generatedId = keyHolder.key?.toInt()
                ?: throw IllegalStateException("Failed to obtain generated key")

            return user.copy(id = generatedId)
        } catch (e: DataAccessException) {
            logger.error("Database access error occurred", e)
            throw CustomDatabaseException("Error occurred while accessing the database", e)
        }
    }

    private fun createPreparedStatementForInsert(connection: Connection, user: UserEntity): PreparedStatement {
        val sql = INSERT_USER_SQL
        return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).apply {
            setString(1, user.alias)
            setString(2, user.email)
        }
    }

    private fun User.toEntity(): UserEntity = UserEntity(
        alias = this.alias,
        email = this.email
    )

    class CustomDatabaseException(message: String, cause: Throwable) : RuntimeException(message, cause)

    companion object {
        @JvmStatic
        private val logger: Logger = LoggerFactory.getLogger(JdbcUserAdapter::class.java)
        private const val INSERT_USER_SQL = "INSERT INTO users (alias, email) VALUES (?, ?)"
    }
}