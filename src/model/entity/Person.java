package model.entity;

import java.util.Date;
import java.util.Optional;

public interface Person {

    public <P extends Person> Optional<P> setBasicData(int id, Date birthDate, String emailAddress);

    int getIdentificationNumber();

    Date getBirthDate();

    String getAddress();
    String getLegalAddress();
    String getSocialAddress();
    String getFullName();

}
