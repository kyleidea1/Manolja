package hackathon.hackathon.repository;

import hackathon.hackathon.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByUuid(String Uuid);

    Optional<Member> findByUuid(String uuid);

    List<Member> findAll();
}
