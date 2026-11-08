package seproject.model.a14;

/** A1-4 支付的抽象父类，由五种具体支付方式继承，对应图上的泛化关系。 */
public abstract class Payment {

    protected double amount;

    /** 执行支付，成功返回 true。 */
    public abstract boolean pay(double money);

    public double getAmount() {
        return amount;
    }

    public String typeName() {
        return this.getClass().getSimpleName();
    }
}
