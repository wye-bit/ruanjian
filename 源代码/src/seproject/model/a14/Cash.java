package seproject.model.a14;

/** 现金支付：以实付现金结算，找零由实付金额与应付金额之差得到。 */
public class Cash extends Payment {

    private double cashTendered;

    @Override
    public boolean pay(double money) {
        if (money <= 0) {
            return false;
        }
        this.cashTendered = money;
        this.amount = money;
        return true;
    }

    public double getCashTendered() {
        return cashTendered;
    }

    public double getChange(double payable) {
        return cashTendered - payable;
    }
}
