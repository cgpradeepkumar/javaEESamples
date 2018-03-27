package sample.cxf.demo.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import sample.cxf.demo.Order;
import sample.cxf.demo.OrderProcess;

/**
 * @author pkumar on 27/3/18
 * @project javaEESamples
 */
public class OrderProcessClient {

    public OrderProcessClient() {

    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"client-beans.xml"});
        System.out.println(context);

        OrderProcess orderProcess = (OrderProcess) context.getBean("orderProcessClient");

        Order order = new Order();
        order.setCustomerId("C001");
        order.setItemId("I001");
        order.setQuantity(2);
        order.setPrice(450.00);

        String orderId = orderProcess.processOrder(order);
        String message = (orderId == null)? "Order failed": "Order created and order Id is " + orderId;
        System.out.println(message);
        System.exit(0);
    }
}
