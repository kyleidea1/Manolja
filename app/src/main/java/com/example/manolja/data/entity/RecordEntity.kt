import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class RecordEntity(
    @PrimaryKey(autoGenerate = true) val recordId: Int = 0,
    val region: String,
    var content: String,
    val imageUri: String,
    val date: String
)
