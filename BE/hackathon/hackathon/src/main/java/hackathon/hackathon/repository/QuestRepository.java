package hackathon.hackathon.repository;

import hackathon.hackathon.domain.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Long> {
//    Quest findQuestByIsToday();
    List<Quest> findByIsTodayTrue();

    List<Quest> findAll();
}
