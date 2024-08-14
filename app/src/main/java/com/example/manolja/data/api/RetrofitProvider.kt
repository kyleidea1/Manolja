package com.example.manolja.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.manolja.data.api.apiservice.MemberApiService
import com.example.manolja.data.api.apiservice.QuestApiService
import com.example.manolja.data.api.apiservice.RewardApiService
import java.util.concurrent.TimeUnit

object RetrofitProvider {

    private const val BASE_URL = "http://ec2-54-180-144-125.ap-northeast-2.compute.amazonaws.com:8080/"

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val memberApiService: MemberApiService by lazy {
        retrofit.create(MemberApiService::class.java)
    }

    val questApiService: QuestApiService by lazy {
        retrofit.create(QuestApiService::class.java)
    }

    val rewardApiService: RewardApiService by lazy {
        retrofit.create(RewardApiService::class.java)
    }
}
