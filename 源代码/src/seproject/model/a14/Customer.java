package seproject.model.a14;

import java.util.ArrayList;
import java.util.List;

/** A1-4 客户：一个客户可以下多个订单（1 对 1..*）。 */
public class Customer {

    private String name;
    private String contact;
    private String deliveryAddress;
    private boolean active;
    private final List<Order> orders = new ArrayList<>();

    public Customer(String name, String contact, String deliveryAddress, boolean active) {
        this.name = name;
        this.contact = contact;
        this.deliveryAddress = deliveryAddress;
        this.active = active;
    }

    public Order placeOrder(Order order) {
        if (!active) {
            throw new IllegalStateException("账号未激活，不能下单");
        }
        orders.add(order);
        order.setCustomer(this);
        return order;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isActive() {
        return active;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
