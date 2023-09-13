package model.util;

public enum AccountType {
    CURRENT,
    WALLET,
    SAVINGS,
    PAYSLIP,
    INTERNATIONAL;

    public int getValue(){
        return this.ordinal() + 1;
    }
}
