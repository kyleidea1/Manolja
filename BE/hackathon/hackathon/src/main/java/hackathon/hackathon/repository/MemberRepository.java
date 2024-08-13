package hackathon.hackathon.repository;

import hackathon.hackathon.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByUuid(String Uuid);
}
