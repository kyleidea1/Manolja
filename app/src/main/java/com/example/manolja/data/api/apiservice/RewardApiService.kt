package com.example.manolja.data.api.apiservice

import com.example.manolja.data.api.apiresponse.RewardApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RewardApiService {
    @GET("reward/select/{uuid}")
    suspend fun getReward(@Path("uuid") uuid: String): RewardApiResponse
}