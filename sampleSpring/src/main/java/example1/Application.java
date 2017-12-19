package example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pkumar on 26/9/17.
 */

@Configuration
@ComponentScan
public class Application {

    @Bean
    public MessageService messageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "This is a message from serviceX.";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        context.getBean(MessagePrinter.class).printMessage();
    }
}
