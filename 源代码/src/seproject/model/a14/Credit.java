package seproject.model.a14;

import java.time.LocalDate;

/** 信用卡支付：校验卡号与有效期。 */
public class Credit extends Payment {

    private String number;
    private String type;
    private LocalDate expireDate;

    public Credit(String number, String type, LocalDate expireDate) {
        this.number = number;
        this.type = type;
        this.expireDate = expireDate;
    }

    @Override
    public boolean pay(double money) {
        if (number == null || number.isEmpty()) {
            return false;
        }
        if (expireDate == null || expireDate.isBefore(LocalDate.now())) {
            return false;
        }
        this.amount = money;
        return true;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
}
