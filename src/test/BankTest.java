package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import process.BankProcess;

public class BankTest {

    @Test
    public void test(){
        BankProcess processTest = new BankProcess();
        final String name = processTest.getBankInfo();
        Assertions.assertEquals("Bancolombia", name);
    }

}
