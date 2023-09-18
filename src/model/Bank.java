package model;

import model.account.BankAccount;
import model.entity.Person;
import model.util.AccountType;
import model.util.BankFileMan;
import model.util.PersonType;

import java.util.*;

public class Bank {
    private static final String DATA_PATH = "C:\\Program Files\\Tecnicas\\bank_data.txt";
    private static final String SECONDARY_PATH = System.getProperty("user.home") + "\\Documents\\Tecnicas\\bank_data.txt";
    private String actualPath;

    private static final String DEFAULT_FILE_DATA = "admin,admin;";

    String name;
    List<Integer> accountIds = new ArrayList<>();


    public Bank(String name){
        this.name = name;
        String rawData = this.getFileData();
        List<String> accounts = this.parseData(rawData);
        this.writeDataToFile(accounts);

    }
    protected String getFileData(){
        String data = "";

        if(BankFileMan.exists(DATA_PATH)){
            this.actualPath = DATA_PATH;
            data = BankFileMan.read(this.actualPath).orElse("");

        } else if (BankFileMan.exists(SECONDARY_PATH)) {
            this.actualPath = SECONDARY_PATH;
            data = BankFileMan.read(this.actualPath).orElse("");

        } else {
            if(BankFileMan.create(DATA_PATH)){
                this.actualPath = DATA_PATH;

            } else if (BankFileMan.create(SECONDARY_PATH)) {
                this.actualPath = SECONDARY_PATH;
            }

            data = DEFAULT_FILE_DATA;

        }

        return data;
    }
    protected boolean writeDataToFile(List<String> data){
        return BankFileMan.write(this.actualPath, data);
    }
    protected boolean addToFileData(String data){
        List<String> dataList = this.parseData(this.getFileData());
        dataList.add(data);
        return this.writeDataToFile(dataList);
    }
    protected List<String> parseData(String rawData){
        List<String> processedData = new ArrayList<>(Arrays.asList(rawData.split(";")));
        return processedData;
    }

    public String getName(){
        return this.name;
    }

    List<Integer> getAccountsIds(){
        List<String> accounts = this.parseData(this.getFileData());


        return this.accountIds;
    }

    protected Optional<BankAccount<? extends Person>> requestAccount(int accountID){
        if(!this.accountIds.contains(accountID)){
            return Optional.empty();
        }

        this.parseData(this.getFileData());


        return null;
    }

    public boolean registerNewAccount(AccountType accountType, PersonType type, int id, Date birthDate, String email) {
        Optional<Person> p = type.create();
        if(p.isPresent()) {
            p = p.get().setBasicData(id, birthDate, email);
        }
        if(p.isPresent()){
            BankAccount newAccount = BankAccount.create(p.get(), accountType);
        }


        return true;
    }

}
