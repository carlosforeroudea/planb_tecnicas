package front;

import process.bank_process;

public class init {
    public static void main(String[] args){
        bank_process b = new bank_process();
        new Login().setVisible(true);

    }

}
