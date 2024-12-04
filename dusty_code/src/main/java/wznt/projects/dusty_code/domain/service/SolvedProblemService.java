package wznt.projects.dusty_code.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wznt.projects.dusty_code.domain.controller.response.SolvedProblemResponse;
import wznt.projects.dusty_code.domain.entity.SolvedProblems;
import wznt.projects.dusty_code.domain.repository.SolvedProblemRepository;
import wznt.projects.dusty_code.domain.service.dto.solvedProblems.SolvedProblemDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class SolvedProblemService {
    private final SolvedProblemRepository solvedProblemRepository;

    public void savaSolvedProblem(SolvedProblemDto solvedProblemDto){
        SolvedProblems solvedProblem = SolvedProblems.builder()
                .problemTitle(solvedProblemDto.getProblemTitle())
                .problemURL(solvedProblemDto.getProblemURL())
                .problemType(solvedProblemDto.getProblemType())
                .solvedDate(solvedProblemDto.getSolvedDate())
                .goodToKnow(solvedProblemDto.getGoodToKnow())
                .build();
        solvedProblemRepository.save(solvedProblem);
    }

    public List<SolvedProblemResponse> getSolveProblemList(){
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysAgo = today.minusDays(30);

        List<SolvedProblems> solvedProblemsList = solvedProblemRepository.findBySolvedDateGreaterThanEqualAndSolvedDateLessThanEqual(thirtyDaysAgo,today);

        List<SolvedProblemResponse> solvedProblemResponseList = new ArrayList<>();
        solvedProblemsList.forEach(
                (solvedProblems -> {
                    solvedProblemResponseList.add(
                            SolvedProblemResponse.builder()
                                    .problemTitle(solvedProblems.getProblemTitle())
                                    .problemId(solvedProblems.getProblemId())
                                    .problemType(solvedProblems.getProblemType())
                                    .problemURL(solvedProblems.getProblemURL())
                                    .solvedDate(solvedProblems.getSolvedDate())
                                    .goodToKnow(solvedProblems.getGoodToKnow())
                                    .build()
                    );
                })
        );
        return solvedProblemResponseList;
    }
}
