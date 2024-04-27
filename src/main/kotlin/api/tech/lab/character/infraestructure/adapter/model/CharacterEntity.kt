import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "characters")
data class CharacterEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: String,

    val gender: String,
    val species: String,
    val origin: String,
    val location: String,
    val image: String,

    @ElementCollection
    val episodes: List<String>,

    val url: String,

    @Column(nullable = false)
    val created: LocalDate = LocalDate.now(),

    @Column(nullable = false)
    val updated: LocalDate = LocalDate.now()
)
