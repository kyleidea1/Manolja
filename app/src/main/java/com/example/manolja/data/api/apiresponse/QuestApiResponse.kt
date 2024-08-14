package com.example.manolja.data.api.apiresponse

data class QuestApiResponse(
    val name: String,
    val content: String,
    val exp: Int,
    val place: String
)

data class CouponApiResponse(
    val rewardNo: Int,
    val name: String,
    val content: String,
    val coupon: String,
    val place: String,
    val discount: Double
)