package process;

import model.Bank;

public class bank_process {
    Bank banco;

    public bank_process(){
        banco = new Bank("Bancolombia");
    }
    public String get_bank_info(){
        return banco.get_name();
    }


}
