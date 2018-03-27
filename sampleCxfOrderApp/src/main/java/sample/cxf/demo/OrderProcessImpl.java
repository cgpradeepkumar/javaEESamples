package sample.cxf.demo;

import javax.jws.WebService;

/**
 * @author pkumar on 23/3/18
 * @project javaEESamples
 */

@WebService
public class OrderProcessImpl implements OrderProcess {
    @Override
    public String processOrder(Order order) {
        String orderId = validate(order);
        return orderId;
    }

    private String validate(Order order) {
        if (order.getCustomerId() != null && order.getItemId() != null && order.getQuantity() > 0 && order.getPrice() > 0.0) {
            return order.getCustomerId() + "_" + order.getItemId() + "_" + Math.random();
        }
        return null;
    }
}
