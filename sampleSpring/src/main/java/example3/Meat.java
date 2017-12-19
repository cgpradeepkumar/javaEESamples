package example3;

/**
 * Created by pkumar on 27/9/17.
 */
public class Meat {

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
