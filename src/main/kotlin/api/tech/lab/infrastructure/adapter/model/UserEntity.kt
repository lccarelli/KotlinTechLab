package api.tech.lab.infrastructure.adapter.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("user")
data class UserEntity(
    @Id val id: Int? = null,
    val alias: String,
    val email: String,
)