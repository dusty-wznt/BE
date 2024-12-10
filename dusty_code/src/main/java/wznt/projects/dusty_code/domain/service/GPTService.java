package wznt.projects.dusty_code.domain.service;

import org.springframework.stereotype.Service;
import wznt.projects.dusty_code.global.dto.CompletionRequestDto;

import java.util.List;
import java.util.Map;

@Service
public interface GPTService {
    List<Map<String,Object>> modelList();

    Map<String, Object> prompt(CompletionRequestDto completionRequestDto);
    Map<String,Object> isValidModel(String modelName);
}
