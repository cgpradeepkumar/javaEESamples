package sample.cxf.demo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pkumar on 23/3/18
 * @project javaEESamples
 */

@XmlRootElement(name = "Order")
public class Order {
    private String customerId;
    private String itemId;
    private int quantity;
    private double price;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
