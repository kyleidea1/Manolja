package com.example.manolja.data

import RecordEntity
import com.example.manolja.data.entity.UserEntity

// RecordEntity 더미 데이터
val dummyRecords = listOf(
    RecordEntity(
        title = "다대포",
        content = "다대포의 아름다운 일몰",
        imagePath = "https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/9db411f6-8dcc-4a51-b4d3-eeb541a66bc5.jpeg",
        date = "2024-08-13"
    ),
    RecordEntity(
        title = "해운대",
        content = "해운대의 시원한 바다",
        imagePath = "https://datacdn.ibtravel.co.kr/files/2023/07/26104528/2da24b5030684f9f86cc2884f0e6329e_img-1.jpeg",
        date = "2024-08-14"
    ),
    RecordEntity(
        title = "광안리",
        content = "광안리의 화려한 야경",
        imagePath = "https://www.esquirekorea.co.kr/resources_old/online/org_online_image/eq/9a92826b-fd69-4a92-aad7-36e7217f14f0.jpg",
        date = "2024-08-15"
    )
)

// UserEntity 더미 데이터
val dummyUsers = listOf(
    UserEntity(
        nickname = "김민혁",
        uuid = "uuid_kyle_123",
        exp = 2000,
    ),
    UserEntity(
        nickname = "김정희",
        uuid = "uuid_jenny_456",
        exp = 1500,
    ),
    UserEntity(
        nickname = "김현민",
        uuid = "uuid_sheep_789",
        exp = 2500,
    ),
    UserEntity(
        nickname = "임경윤",
        uuid = "uuid_taewoong_789",
        exp = 2000,
    ),
    UserEntity(
        nickname = "김주송",
        uuid = "uuid_joosoi_789",
        exp = 2500,
    ),
    UserEntity(
        nickname = "박순홍",
        uuid = "uuid_estj_789",
        exp = 2500,
    )

)

