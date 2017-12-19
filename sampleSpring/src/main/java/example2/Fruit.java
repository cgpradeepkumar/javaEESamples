package example2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by pkumar on 26/9/17.
 */
@Component
@PropertySource(value = {"classpath:app.properties"})
public class Fruit {

    @Value("${fruit.def}")
    private String definition = "not set";

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String talkAboutYourself() {
        return getDefinition();
    }
}
