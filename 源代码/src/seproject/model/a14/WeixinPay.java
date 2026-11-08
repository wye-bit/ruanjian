package seproject.model.a14;

/** 微信支付：以微信账号完成支付。 */
public class WeixinPay extends Payment {

    private String number;

    public WeixinPay(String number) {
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
