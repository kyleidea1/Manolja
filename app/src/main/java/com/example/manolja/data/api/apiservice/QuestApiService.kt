package com.example.manolja.data.api.apiservice

import com.example.manolja.data.api.apiresponse.CouponApiResponse
import com.example.manolja.data.api.apiresponse.QuestApiResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface QuestApiService {
    @GET("quest/today")
    suspend fun getTodayQuest(): QuestApiResponse

    @POST("quest/complete/{uuid}")
    suspend fun getCompletedQuests(@Path("uuid") uuid: String): List<QuestApiResponse>

    @GET("quest/setComplete/{uuid}")
    suspend fun setComplete(@Path("uuid") uuid: String): Unit

    @GET("quest/isComplete/{uuid}")
    suspend fun isComplete(@Path("uuid") uuid: String): Boolean

    @GET("quest/coupon/{uuid}")
    suspend fun checkCoupon(@Path("uuid") uuid: String): CouponApiResponse
}