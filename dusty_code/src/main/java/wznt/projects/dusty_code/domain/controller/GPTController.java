package wznt.projects.dusty_code.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wznt.projects.dusty_code.domain.service.GPTService;
import wznt.projects.dusty_code.global.dto.CompletionRequestDto;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/chatGPT")
public class GPTController {
    private final GPTService gptService;


    public GPTController(GPTService gptService) {
        this.gptService = gptService;
    }


    // 모델 리스트 조회
    @GetMapping("/modelList")
    public ResponseEntity<List<Map<String, Object>>> selectModelList() {
        List<Map<String, Object>> result = gptService.modelList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



    // 유효 모델 여부 조회
    @GetMapping("/model")
    public ResponseEntity<Map<String, Object>> isValidModel(@RequestParam(name = "modelName") String modelName) {
        Map<String, Object> result = gptService.isValidModel(modelName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    // gpt 모델 리스트를 조회

    @PostMapping("/prompt")
    public ResponseEntity<Map<String, Object>> selectPrompt(@RequestBody CompletionRequestDto completionRequestDto) {
        Map<String, Object> result = gptService.prompt(completionRequestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
