package wznt.projects.dusty_code.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wznt.projects.dusty_code.domain.controller.request.SolvedProblemRequest;
import wznt.projects.dusty_code.domain.controller.response.SolvedProblemResponse;
import wznt.projects.dusty_code.domain.service.SolvedProblemService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class SolvedProblemsController {

    private final SolvedProblemService solvedProblemService;

    @PostMapping("/saveProblems")
    public ResponseEntity<Void> registerProblem(@RequestBody SolvedProblemRequest solvedProblemRequest){
        solvedProblemService.savaSolvedProblem(solvedProblemRequest.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/solvedProblem")
    public ResponseEntity<List<SolvedProblemResponse>> getToSolveProblem(){
        List<SolvedProblemResponse> solvedProblemResponseList = solvedProblemService.getSolveProblemList();
        return ResponseEntity.ok(solvedProblemResponseList);
    }



}
