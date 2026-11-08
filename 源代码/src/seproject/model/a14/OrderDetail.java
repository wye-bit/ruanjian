package seproject.model.a14;

/** A1-4 订单详情：一条明细对应一种商品及其数量。 */
public class OrderDetail {

    private int quantity;
    private Product product;

    public OrderDetail(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("订单明细的商品与数量必须有效");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateSubTotal() {
        return product.getPriceForQuantity(quantity);
    }

    public double calculateWeight() {
        return product.getWeight() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
