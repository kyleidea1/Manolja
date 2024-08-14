package com.example.manolja.data.api.apiservice

import com.example.manolja.data.api.apiresponse.RewardApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RewardApiService {
    @GET("reward/select/{uuid}")
    suspend fun getReward(@Path("uuid") uuid: String): RewardApiResponse

    @GET("reward/select/{rewardNo}/{uuid}")
    suspend fun selectReward(@Path("rewardNo") rewardNo: Long, @Query("uuid") uuid: String): Unit
}