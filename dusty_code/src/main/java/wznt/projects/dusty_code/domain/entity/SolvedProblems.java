package wznt.projects.dusty_code.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolvedProblems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "problemId")
    private Long problemId;
    private String problemTitle;
    private String problemURL;
    private String problemType;

    private LocalDate solvedDate;

    private String goodToKnow;

}
