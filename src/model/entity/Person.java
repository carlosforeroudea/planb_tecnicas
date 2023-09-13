package model.entity;

import java.util.Date;

public interface Person {
    int getIdentificationNumber();

    Date getBirthDate();

    String getAddress();
    String getLegalAddress();
    String getSocialAddress();
    String getFullName();

}
