package com.example.manolja.ui.fragment

import RecordAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manolja.R
import com.example.manolja.data.RecordItem

class RecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_record, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        val recordItems = listOf(
            RecordItem("2024.08.12", "다대포 해수욕장에서 노을을 보다...", "https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/9db411f6-8dcc-4a51-b4d3-eeb541a66bc5.jpeg"),
            RecordItem("2024.08.13", "광안리에서 보트를 타다...", "https://datacdn.ibtravel.co.kr/files/2023/07/26104528/2da24b5030684f9f86cc2884f0e6329e_img-1.jpeg"),
            RecordItem("2024.08.14", "맛집 탐방", "https://www.esquirekorea.co.kr/resources_old/online/org_online_image/eq/9a92826b-fd69-4a92-aad7-36e7217f14f0.jpg")
        )

        recyclerView.adapter = RecordAdapter(recordItems)

        return view
    }
}
