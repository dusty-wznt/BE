package wznt.projects.dusty_code.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class SolvedCode {

    // 사용 보류

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solvedCodeId")
    private Long solvedCodeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solvedProblem")
    private SolvedProblems solvedProblem;


    private String codeSentences;
}
