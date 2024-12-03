package wznt.projects.dusty_code.domain.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.format.annotation.DateTimeFormat;
import wznt.projects.dusty_code.domain.entity.SolvedProblems;
import wznt.projects.dusty_code.domain.service.dto.solvedProblems.SolvedProblemDto;

import java.time.LocalDate;

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
                .problemTitle(this.problemTitle)
                .problemURL(this.problemURL)
                .solvedDate(this.solvedDate)
                .problemType(this.problemType)
                .goodToKnow(this.goodToKnow).build();
    }
}
