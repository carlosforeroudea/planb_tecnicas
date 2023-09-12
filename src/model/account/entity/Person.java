package model.account.entity;

import java.util.Date;
import java.util.Locale;

public interface Person {
    int getIdentificationNumber();

    Date getBirthDate();

    Locale getLegalAddress();
    Locale getSocialAddress();
    String getFullName();

}
