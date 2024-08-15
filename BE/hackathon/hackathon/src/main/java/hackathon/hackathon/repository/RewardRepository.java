package hackathon.hackathon.repository;

import hackathon.hackathon.domain.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward, Long> {
    List<Reward> findRewardsByPlace(String place);

    Reward findRewardByRewardNo(long rewardNo);
}
