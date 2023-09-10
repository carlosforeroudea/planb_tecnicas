package front;

import process.bank_process;

public class init {
    public static void main(String[] args){
        bank_process b = new bank_process();
        Home inicio = new Home(b);


        inicio.setVisible(true);
        inicio.setSize(500,500);

    }
}
