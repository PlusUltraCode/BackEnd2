package toy.withme58.db.memberquestion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface MemberQuestionRepository extends JpaRepository<MemberQuestionEntity, Long> {

    Optional<MemberQuestionEntity> findByMemberIdAndQuestionId(Long memberId, Long questionId);

    Optional<MemberQuestionEntity> findByCreatedAt(LocalDate now);
}
