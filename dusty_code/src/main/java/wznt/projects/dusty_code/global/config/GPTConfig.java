package wznt.projects.dusty_code.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GPTConfig {
    @Value("${openai.secret-key}")
    private String secretKey;


    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean
    public  HttpHeaders httpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("AUthorization","Bearer"+secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
