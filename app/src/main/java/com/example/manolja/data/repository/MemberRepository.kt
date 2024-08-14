import com.example.manolja.data.api.apiresponse.MemberGet
import com.example.manolja.data.api.apiresponse.MemberPost
import com.example.manolja.data.api.apiservice.MemberApiService

class MemberRepository(private val memberService: MemberApiService) {

    // 멤버 초기화 API 호출
    suspend fun initMember(uuid: String, nickname: String) {
        val memberPost = MemberPost(uuid, nickname)
        try {
            memberService.initMember(memberPost)
        } catch (e: Exception) {
            // 에러 처리 로직 추가
            throw e
        }
    }

    // 사용자 정보 조회 API 호출
    suspend fun getMember(uuid: String): MemberGet {
        return try {
            memberService.getMember(uuid)
        } catch (e: Exception) {
            // 에러 처리 로직 추가
            throw e
        }
    }
}

