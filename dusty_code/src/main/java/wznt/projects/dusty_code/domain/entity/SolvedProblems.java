package wznt.projects.dusty_code.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class SolvedProblems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "problemId")
    private Long problemId;
    private String problemTitle;
    private String problemURL;
    private String problemType;

    private LocalDate solvedDate;

}
