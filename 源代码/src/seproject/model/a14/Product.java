package seproject.model.a14;

/** A1-4 商品：提供按数量计价与取重量两个操作。 */
public class Product {

    private String title;
    private double weight;
    private String description;
    private double unitPrice;

    public Product(String title, double weight, String description, double unitPrice) {
        this.title = title;
        this.weight = weight;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public double getPriceForQuantity(int qty) {
        return unitPrice * qty;
    }

    public double getWeight() {
        return weight;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
