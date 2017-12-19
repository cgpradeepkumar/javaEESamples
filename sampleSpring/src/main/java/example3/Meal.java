package example3;

/**
 * Created by pkumar on 27/9/17.
 */
public class Meal {

    private Meat meat;

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public void whatsInThisMeal() {
        System.out.println("--Contents of the Meal--");

        if (getMeat() != null) System.out.println(getMeat().talkAboutYourself());
    }
}
