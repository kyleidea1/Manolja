package hackathon.hackathon.service;

import hackathon.hackathon.domain.Member;
import hackathon.hackathon.domain.Quest;
import hackathon.hackathon.repository.MemberRepository;
import hackathon.hackathon.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SchedularService {

    private final MemberRepository memberRepository;
    private final QuestRepository questRepository;

    @Autowired
    SchedularService(MemberRepository memberRepository, QuestRepository questRepository) {
        this.memberRepository = memberRepository;
        this.questRepository = questRepository;
    }


    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduled() {
        System.out.println("Scheduled!");
        List<Member> memberList = memberRepository.findAll();
        for(Member member : memberList) {
            if(member.getReward() != null) {
                member.setRewardNull();
            }
        }
        List<Quest> questList = questRepository.findAll();
        for(int i=0; i<questList.size(); i++) {
            Quest quest = questList.get(i);
            if(quest.isToday())
                quest.switchIsToday();
            questList.get((i+1) % questList.size()).switchIsToday();
        }
    }
}
