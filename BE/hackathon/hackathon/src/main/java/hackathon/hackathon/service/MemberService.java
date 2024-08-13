package hackathon.hackathon.service;

import hackathon.hackathon.domain.Member;
import hackathon.hackathon.dto.MemberSaveRequestDto;
import hackathon.hackathon.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void saveMember(MemberSaveRequestDto memberSaveRequestDto) throws IllegalAccessException {
        if(memberRepository.existsByUuid(memberSaveRequestDto.getUuid()))
            throw new IllegalAccessException("이미 존재하는 회원입니다.");
        Member member = new Member(
                memberSaveRequestDto.getUuid(),
                memberSaveRequestDto.getNickname(),
                0);
        memberRepository.save(member);
    }
}
