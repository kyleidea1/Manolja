package hackathon.hackathon.repository;

import hackathon.hackathon.domain.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward, Long> {
}
