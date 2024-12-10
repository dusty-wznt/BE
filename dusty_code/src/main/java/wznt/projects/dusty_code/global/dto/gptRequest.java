package wznt.projects.dusty_code.global.dto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class gptRequest {
    private String model;
    private List<Message> messages;

    public gptRequest(String model, String prompt) {
        this.model = model;
        this.messages =  new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }
}
