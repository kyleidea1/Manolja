import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manolja.R
import com.example.manolja.databinding.DialogQuestDetailsBinding
import com.example.manolja.databinding.FragmentQuestBinding
import com.example.manolja.ui.Quest

class QuestFragment : Fragment() {

    private var _binding: FragmentQuestBinding? = null
    private val binding get() = _binding!!

    private lateinit var questAdapter: QuestAdapter
    private lateinit var questList: List<Quest>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestBinding.inflate(inflater, container, false)
        val view = binding.root

        // 여기에다가 받아온 데이터 담기
        questList = listOf(
            Quest("퀘스트 1", "부산시 금정구", "치킨쿠폰"),
            Quest("퀘스트 2", "부산시 현민구", "피자쿠폰")
        )

        questAdapter = QuestAdapter(questList) { quest ->
            showQuestDetailsDialog(quest)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = questAdapter

        return view
    }

    private fun showQuestDetailsDialog(quest: Quest) {
        val dialogBinding = DialogQuestDetailsBinding.inflate(LayoutInflater.from(context))

        // 여기에 받아오는 정보 넣기
        dialogBinding.tvDate.text = "날짜 정보"
        dialogBinding.tvQuestName.text = quest.name
        dialogBinding.tvCompleted.text = "완료됨"
        dialogBinding.tvReward.text = quest.reward
        dialogBinding.tvLocation.text = quest.location

        AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .setPositiveButton("확인", null)
            .create()
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
