package process;

import model.bank.Bank;

public class BankProcess {
    Bank bank;

    public BankProcess(){
        bank = new Bank("Bancolombia");
    }
    public String getBankInfo(){
        return bank.getName();
    }


}
