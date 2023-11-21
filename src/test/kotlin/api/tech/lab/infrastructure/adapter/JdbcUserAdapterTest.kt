package api.tech.lab.infrastructure.adapter

import api.tech.lab.domain.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.slot
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.springframework.dao.DataAccessResourceFailureException
import org.springframework.jdbc.core.PreparedStatementCreator

class JdbcUserAdapterTest {

    private val jdbcTemplate: JdbcTemplate = mockk(relaxed = true)
    private val jdbcUserAdapter = JdbcUserAdapter(jdbcTemplate)

    @Test
    fun `save should save user and return with generated id`() {
        val user = User(alias = "testAlias", email = "test@test.com")
        val generatedKey: Number = 1
        val keyHolderSlot = slot<GeneratedKeyHolder>()

        every {
            jdbcTemplate.update(any<PreparedStatementCreator>(), capture(keyHolderSlot))
        } answers {
            keyHolderSlot.captured.keyList.add(mapOf("GENERATED_KEY" to generatedKey))
            1 // Number of rows affected
        }

        val savedUser = jdbcUserAdapter.save(user)

        assertEquals(generatedKey.toInt(), savedUser.id)
        verify { jdbcTemplate.update(any<PreparedStatementCreator>(), any()) }
    }

    @Test
    fun `save should  throw CustomDatabaseException when database access fails`() {
        val user = User(alias = "testAlias", email = "test@test.com")
        val keyHolderSlot = slot<GeneratedKeyHolder>()

        every {
            jdbcTemplate.update(any<PreparedStatementCreator>(), capture(keyHolderSlot))
        } answers {
            throw DataAccessResourceFailureException("Database access error occurred")
        }

        assertThrows(JdbcUserAdapter.CustomDatabaseException::class.java){
            jdbcUserAdapter.save(user)
        }
    }
}
