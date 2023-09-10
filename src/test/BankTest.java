package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import process.bank_process;

public class BankTest {

    @Test
    public void test(){
        bank_process procesotest = new bank_process();
        final String nombre = procesotest.get_bank_info();
        Assertions.assertEquals("Bancolombia",nombre);
    }

}
