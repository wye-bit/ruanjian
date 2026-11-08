package seproject.model.a14;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** A1-4 订单：包含 1..* 条订单详情（组合），并对应 0..1 笔支付。 */
public class Order {

    private LocalDate createDate;
    private OrderStatus status;
    private Customer customer;
    private Payment payment;
    private final List<OrderDetail> details = new ArrayList<>();

    public Order(LocalDate createDate) {
        this.createDate = createDate;
        this.status = OrderStatus.CREATE;
    }

    public void addDetail(OrderDetail detail) {
        if (detail != null && !details.contains(detail)) {
            details.add(detail);
        }
    }

    /** 明细随订单生成与销毁，因此用组合：订单取消时一并清空。 */
    public void cancel() {
        status = OrderStatus.CANCEL;
        details.clear();
    }

    public double calcTotal() {
        double total = 0;
        for (OrderDetail detail : details) {
            total += detail.calculateSubTotal();
        }
        return total;
    }

    public double calcWeight() {
        double weight = 0;
        for (OrderDetail detail : details) {
            weight += detail.calculateWeight();
        }
        return weight;
    }

    public boolean pay(Payment payment) {
        if (status != OrderStatus.CREATE) {
            return false;
        }
        boolean ok = payment.pay(calcTotal());
        if (ok) {
            this.payment = payment;
            status = OrderStatus.PAID;
        }
        return ok;
    }

    public void ship() {
        if (status == OrderStatus.PAID) {
            status = OrderStatus.SHIPPING;
        }
    }

    public void deliver() {
        if (status == OrderStatus.SHIPPING) {
            status = OrderStatus.DELIVERED;
        }
    }

    void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }
}
