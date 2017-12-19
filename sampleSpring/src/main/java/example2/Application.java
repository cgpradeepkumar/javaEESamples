package example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pkumar on 26/9/17.
 */
@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        Fruit fruit = context.getBean(Fruit.class);
        System.out.println(fruit.talkAboutYourself());

        Vegetable vegetable = context.getBean(Vegetable.class);
        System.out.println(vegetable.talkAboutYourself());
    }
}
