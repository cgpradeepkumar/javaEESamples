package example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pkumar on 27/9/17.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Meal meal1 = context.getBean("meal", Meal.class);
        meal1.whatsInThisMeal();

        Meal meal2 = context.getBean("mealOuterBean", Meal.class);
        meal2.whatsInThisMeal();
    }
}
