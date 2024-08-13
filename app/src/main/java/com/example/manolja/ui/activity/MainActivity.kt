package com.example.manolja.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manolja.R
import com.example.manolja.databinding.ActivityMainBinding
import com.example.manolja.ui.fragment.HomeFragment
import com.example.manolja.ui.fragment.QuestFragment
import com.example.manolja.ui.fragment.RecordFragment
//import com.example.manolja.data.api.ApiService
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

//    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Retrofit 객체 생성
//        setupRetrofit()

        // 바텀 네비게이션 설정
        setupBottomNavigationView()

        // 첫 화면으로 홈 프래그먼트 로드
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }

//    private fun setupRetrofit() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://manolja.com/") // 여기에 백엔드 API의 기본 URL을 넣으세요.
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        apiService = retrofit.create(ApiService::class.java)
//    }

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
            .addToBackStack(null)  // 뒤로가기 버튼을 통해 이전 프래그먼트로 돌아갈 수 있도록 함
            .commit()               // 트랜잭션 커밋
    }
}
