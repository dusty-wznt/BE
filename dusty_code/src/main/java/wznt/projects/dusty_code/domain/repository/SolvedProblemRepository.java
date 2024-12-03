package wznt.projects.dusty_code.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import wznt.projects.dusty_code.domain.entity.SolvedProblems;

import java.time.LocalDate;
import java.util.List;

public interface SolvedProblemRepository  extends JpaRepository<SolvedProblems, Long> {
    List<SolvedProblems> findBySolvedDateGreaterThanEqualAndSolvedDateLessThanEqual(LocalDate expiredPeriod, LocalDate today);

}
