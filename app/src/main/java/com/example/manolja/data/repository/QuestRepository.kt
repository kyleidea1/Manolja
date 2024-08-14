package com.example.manolja.data.repository

import com.example.manolja.data.api.apiresponse.QuestApiResponse
import com.example.manolja.data.api.apiservice.QuestApiService

class QuestRepository(private val questApiService: QuestApiService) {

    // 오늘의 퀘스트를 가져옵니다.
    suspend fun getTodayQuest(): QuestApiResponse {
        return try {
            questApiService.getTodayQuest()
        } catch (e: Exception) {
            // 에러 처리 로직 추가
            throw e
        }
    }

    // 완료된 퀘스트를 가져옵니다.
    suspend fun getCompletedQuests(uuid: String): List<QuestApiResponse> {
        return try {
            questApiService.getCompletedQuests(uuid)
        } catch (e: Exception) {
            // 에러 처리 로직 추가
            throw e
        }
    }

    // 퀘스트 완료 상태를 설정합니다.
    suspend fun setComplete(uuid: String) {
        try {
            questApiService.setComplete(uuid)
        } catch (e: Exception) {
            // 에러 처리 로직 추가
            throw e
        }
    }

    // 퀘스트 완료 여부를 확인합니다.
    suspend fun isComplete(uuid: String): Boolean {
        return try {
            questApiService.isComplete(uuid)
        } catch (e: Exception) {
            // 에러 처리 로직 추가
            throw e
        }
    }
}

