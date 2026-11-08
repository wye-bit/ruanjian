package seproject.model.a14;

/** 支付宝支付：以支付宝账号完成支付。 */
public class AliPay extends Payment {

    private String number;

    public AliPay(String number) {
        this.number = number;
    }

    @Override
    public boolean pay(double money) {
        if (number == null || number.isEmpty()) {
            return false;
        }
        this.amount = money;
        return true;
    }

    public String getNumber() {
        return number;
    }
}
