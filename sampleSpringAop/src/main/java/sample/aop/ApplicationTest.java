package sample.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pkumar on 27/9/17.
 */
public class ApplicationTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        CustomerBo customerBo = context.getBean("customerBo", CustomerBo.class);
        customerBo.addCustomer();
        customerBo.addCustomerAround("");
        customerBo.addCustomerReturnValue();
        try {
            customerBo.addCustomerThrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
