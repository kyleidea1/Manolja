package hackathon.hackathon.service;

import hackathon.hackathon.domain.Member;
import hackathon.hackathon.domain.MemberQuest;
import hackathon.hackathon.domain.Quest;
import hackathon.hackathon.domain.Reward;
import hackathon.hackathon.dto.QuestSaveRequestDto;
import hackathon.hackathon.dto.QuestResponseDto;
import hackathon.hackathon.dto.RewardSaveRequestDto;
import hackathon.hackathon.repository.MemberQuestRepository;
import hackathon.hackathon.repository.MemberRepository;
import hackathon.hackathon.repository.QuestRepository;
import hackathon.hackathon.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class QuestService {

    private final QuestRepository questRepository;
    private final MemberQuestRepository memberQuestRepository;
    private final MemberRepository memberRepository;
    private final RewardRepository rewardRepository;

    @Autowired
    QuestService(QuestRepository questRepository, MemberQuestRepository memberQuestRepository, MemberRepository memberRepository
    , RewardRepository rewardRepository) {
        this.questRepository = questRepository;
        this.memberQuestRepository = memberQuestRepository;
        this.memberRepository = memberRepository;
        this.rewardRepository = rewardRepository;
    }

    public void createQuest(QuestSaveRequestDto questSaveRequestDto) {
        Quest quest = new Quest(questSaveRequestDto.getName(), questSaveRequestDto.getContent(), questSaveRequestDto.getExp(), false, questSaveRequestDto.getPlace());
        questRepository.save(quest);
    }

    public void createReward(RewardSaveRequestDto rewardSaveRequestDto) {
        Reward reward = new Reward(
                rewardSaveRequestDto.getName(),
                rewardSaveRequestDto.getContent(),
                rewardSaveRequestDto.getCoupon(),
                rewardSaveRequestDto.getPlace()
        );
        rewardRepository.save(reward);
    }

    public QuestResponseDto getTodayQuest() {
        Quest todayQuest = questRepository.findByIsTodayTrue().get(0);
        QuestResponseDto questResponseDto = new QuestResponseDto(
                todayQuest.getName(),
                todayQuest.getContent(),
                todayQuest.getExp(),
                todayQuest.getPlace()
        );
        return questResponseDto;
    }

    public List<QuestResponseDto> getCompleteQuest(String uuid) {
        List<MemberQuest> memberQuestList = memberQuestRepository.findByMember_UuidOrderByDateDesc(uuid);
        List<QuestResponseDto> questResponseDtoList = new ArrayList<>();
        for(MemberQuest mq : memberQuestList) {
            Quest quest = mq.getQuest();
            QuestResponseDto questResponseDto = new QuestResponseDto(
                    quest.getName(),
                    quest.getContent(),
                    quest.getExp(),
                    quest.getPlace());
            questResponseDtoList.add(questResponseDto);
        }
        return questResponseDtoList;
    }

    public void setCompleteQuest(String uuid) {
        Member member = memberRepository.findByUuid(uuid).get();
        Quest todayQuest = questRepository.findByIsTodayTrue().get(0);
        MemberQuest memberQuest = new MemberQuest(member, todayQuest);
        memberQuestRepository.save(memberQuest);
    }
}
