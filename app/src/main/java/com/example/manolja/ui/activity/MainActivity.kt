package com.example.manolja.ui.activity

import QuestFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manolja.R
import com.example.manolja.databinding.ActivityMainBinding
import com.example.manolja.ui.fragment.HomeFragment
import com.example.manolja.ui.fragment.RecordFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBottomNavigationView()

        // 앱이 처음 시작될 때 홈 프래그먼트를 로드
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.fragment_home -> HomeFragment()
                R.id.fragment_quest -> QuestFragment()
                R.id.fragment_record -> RecordFragment()
                else -> null
            }
            fragment?.let {
                loadFragment(it)
                true
            } ?: false
        }
    }

    private fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)  // Back Stack에 추가하여 뒤로 가기 지원
            .commit()               // 트랜잭션 커밋
    }
}
