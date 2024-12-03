package wznt.projects.dusty_code.domain.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolvedProblemResponse {
    private Long problemId;
    private String problemTitle;
    private String problemURL;
    private String problemType;
    private LocalDate solvedDate;
    private String goodToKnow;
}
