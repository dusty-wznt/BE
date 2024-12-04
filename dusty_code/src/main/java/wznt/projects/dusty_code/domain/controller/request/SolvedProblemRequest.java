package wznt.projects.dusty_code.domain.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import wznt.projects.dusty_code.domain.service.dto.solvedProblems.SolvedProblemDto;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SolvedProblemRequest {

    private String problemTitle;
    private String problemURL;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate solvedDate;
    private String problemType;
    private String goodToKnow;


    public SolvedProblemDto toDto(){
        return SolvedProblemDto.builder()
                .problemTitle(problemTitle)
                .problemURL(problemURL)
                .solvedDate(solvedDate)
                .problemType(problemType)
                .goodToKnow(goodToKnow).build();
    }
}
