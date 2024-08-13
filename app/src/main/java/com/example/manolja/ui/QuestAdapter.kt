import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.manolja.databinding.QuestitemBinding
import com.example.manolja.ui.Quest

class QuestAdapter(
    private val questList: List<Quest>,
    private val onItemClick: (Quest) -> Unit
) : RecyclerView.Adapter<QuestAdapter.QuestViewHolder>() {

    inner class QuestViewHolder(private val binding: QuestitemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(quest: Quest) {
            binding.questname.text = quest.name
            binding.location.text = quest.location
            binding.reward.text = quest.reward

            binding.root.setOnClickListener {
                onItemClick(quest)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestViewHolder {
        val binding = QuestitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestViewHolder, position: Int) {
        holder.bind(questList[position])
    }

    override fun getItemCount(): Int {
        return questList.size
    }
}
