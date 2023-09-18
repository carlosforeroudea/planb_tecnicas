/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import model.Transaction;

/**
 *
 * @author carlosforero
 */
public class extract {
    public static void exportReportByAccount(String filePath,Date datefirst, Date datesecond, String account_id)
{   
    HashMap<String,Transaction> transactions = database.get_Transactions();
    
    LocalDateTime date1 = LocalDateTime.ofInstant(datefirst.toInstant(),
                                             ZoneId.systemDefault());
    LocalDateTime date2 = LocalDateTime.ofInstant(datesecond.toInstant(),
                                             ZoneId.systemDefault());
    date1 = LocalDateTime.of(date1.getYear(),date1.getMonth(),date1.getDayOfMonth(),0,0);
    date2 = LocalDateTime.of(date2.getYear(),date2.getMonth(),date2.getDayOfMonth(),23,59);
    
    // first create file object for file placed at location
    // specified by filepath
    File file = new File(filePath);
    try {
        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter(file);
  
        // create CSVWriter object filewriter object as parameter
        CSVWriter writer = new CSVWriter(outputfile);
  
        // adding header to csv
        String[] header = { "Tipo", "identificador_de_transaccion", "cantidad", "fecha", };
        writer.writeNext(header);
        
        
        for (Map.Entry<String, Transaction> entry : transactions.entrySet()) {
            LocalDateTime date = entry.getValue().get_datetime();
            System.out.println(date1.compareTo(date)+" "+date.toString()+" "+date2.compareTo(date) );
            if(entry.getValue().get_account().get_numberAccount().equals(account_id) && date1.compareTo(date)<=0 && date2.compareTo(date)>=0)
            {
                String[] data1 = { entry.getValue().get_type().toString(),entry.getValue().get_uuid(), entry.getValue().get_amount()+"$", entry.getValue().get_datetime().toString() };
                writer.writeNext(data1);
            }
        }
        
        writer.close();
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
