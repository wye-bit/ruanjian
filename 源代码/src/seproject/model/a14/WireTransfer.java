package seproject.model.a14;

/** 在线转账支付：记录银行标识与银行名称。 */
public class WireTransfer extends Payment {

    private String bankID;
    private String bankName;

    public WireTransfer(String bankID, String bankName) {
        this.bankID = bankID;
        this.bankName = bankName;
    }

    @Override
    public boolean pay(double money) {
        if (bankID == null || bankID.isEmpty()) {
            return false;
        }
        this.amount = money;
        return true;
    }

    public String getBankID() {
        return bankID;
    }

    public String getBankName() {
        return bankName;
    }
}
