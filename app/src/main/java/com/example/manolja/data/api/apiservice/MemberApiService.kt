package com.example.manolja.data.api.apiservice

import com.example.manolja.data.api.apiresponse.MemberGet
import com.example.manolja.data.api.apiresponse.MemberPost
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MemberApiService {
    @POST("member/init")
    suspend fun initMember(@Body memberPost: MemberPost): Unit

    @GET("member/{uuid}")
    suspend fun getMember(@Path("uuid") uuid: String): MemberGet
}