package wznt.projects.dusty_code.domain.service.dto.solvedProblems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolvedProblemDto {
    private String problemTitle;
    private String problemURL;
    private LocalDate solvedDate;
    private String problemType;
    private String goodToKnow;
}
