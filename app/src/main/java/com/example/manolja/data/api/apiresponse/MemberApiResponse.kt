package com.example.manolja.data.api.apiresponse

// 사용자 정보 조회 응답 데이터 클래스
data class MemberPost(
    val uuid: String,
    val nickname: String
)

// 사용자 정보 저장 요청 데이터 클래스
data class MemberGet(
    val nickname: String,
    val exp: Int
)
