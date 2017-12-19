package example2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by pkumar on 26/9/17.
 */

@Component
@PropertySource(value = {"classpath:app.properties"})
public class Vegetable {

    @Value("${vegetable.def}")
    private String definition;

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
