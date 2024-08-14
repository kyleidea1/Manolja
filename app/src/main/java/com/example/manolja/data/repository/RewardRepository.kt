package com.example.manolja.data.repository

import com.example.manolja.data.api.apiservice.RewardApiService
import com.example.manolja.data.api.apiresponse.RewardApiResponse

class RewardRepository(private val rewardApiService: RewardApiService) {

    // 특정 UUID에 대한 보상을 가져옵니다.
    suspend fun getReward(uuid: String): RewardApiResponse {
        return try {
            rewardApiService.getReward(uuid)
        } catch (e: Exception) {
            // 에러 처리 로직 추가
            throw e
        }
    }
}
