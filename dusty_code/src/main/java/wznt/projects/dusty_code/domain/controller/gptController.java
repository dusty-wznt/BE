package wznt.projects.dusty_code.domain.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import wznt.projects.dusty_code.global.dto.gptRequest;
import wznt.projects.dusty_code.global.dto.gptResponse;

@RestController
@RequestMapping("/bot")
public class gptController {
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam(name = "prompt")String prompt){
        gptRequest request = new gptRequest(model, prompt);
        gptResponse chatGPTResponse =  template.postForObject(apiURL, request, gptResponse.class);
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
