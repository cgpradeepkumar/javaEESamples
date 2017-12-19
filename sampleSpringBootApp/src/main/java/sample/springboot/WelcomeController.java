package sample.springboot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pkumar on 20/6/17.
 */

@Controller
public class WelcomeController {

    @Value("${welcome.message}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "hello";
    }
}
