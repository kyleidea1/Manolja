package com.example.manolja.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.manolja.R

class HomeFragment : Fragment() {

    private lateinit var ivMail: ImageView
    private lateinit var tvQuestPrompt: TextView
    private lateinit var textContainer: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        ivMail = view.findViewById(R.id.ivMail)
        tvQuestPrompt = view.findViewById(R.id.tvQuestPrompt)
        textContainer = view.findViewById(R.id.textContainer)

        ivMail.setOnClickListener {
            tvQuestPrompt.visibility = View.INVISIBLE
            ivMail.visibility = View.INVISIBLE
            textContainer.visibility = View.VISIBLE
        }

        return view
    }
}
