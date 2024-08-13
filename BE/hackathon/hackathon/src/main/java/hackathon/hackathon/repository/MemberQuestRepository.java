package hackathon.hackathon.repository;

import hackathon.hackathon.domain.MemberQuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberQuestRepository extends JpaRepository<MemberQuest, Long> {
    List<MemberQuest> findByMember_UuidOrderByDateDesc(String uuid);

}
