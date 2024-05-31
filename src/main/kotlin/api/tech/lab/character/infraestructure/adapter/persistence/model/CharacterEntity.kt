import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "characters")
data class CharacterEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String = "",

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: String = "Unknown",

    val gender: String = "Unknown",
    val species: String = "Unknown",
    val origin: String = "Unknown",
    val location: String = "Unknown",
    val image: String = "Unknown",

    @ElementCollection
    val episodes: List<String> = emptyList(),

    val url: String = "",

    @Column(nullable = false)
    val created: LocalDate = LocalDate.now(),

    @Column(nullable = false)
    val updated: LocalDate = LocalDate.now()
)
