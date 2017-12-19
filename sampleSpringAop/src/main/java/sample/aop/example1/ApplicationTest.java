package sample.aop.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by pkumar on 28/9/17.
 */
public class ApplicationTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        AddressBean addressBean = context.getBean(AddressBean.class);
        addressBean.createAddress();
    }
}
