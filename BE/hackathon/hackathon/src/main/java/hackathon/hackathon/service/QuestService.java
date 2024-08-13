package hackathon.hackathon.service;

import hackathon.hackathon.domain.Quest;
import hackathon.hackathon.dto.QuestSaveRequestDto;
import hackathon.hackathon.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class QuestService {

    private final QuestRepository questRepository;

    @Autowired
    QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public void createQuest(QuestSaveRequestDto questSaveRequestDto) {
        Quest quest = new Quest(questSaveRequestDto.getName(), questSaveRequestDto.getContent(), questSaveRequestDto.getExp(), false);
        questRepository.save(quest);
    }
}
