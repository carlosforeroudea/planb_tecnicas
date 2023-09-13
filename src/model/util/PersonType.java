package model.util;

import model.entity.Employee;
import model.entity.LegalEntity;
import model.entity.NaturalEntity;
import model.entity.Person;

import java.util.Arrays;

public enum PersonType {
    NONE(null),
    EMPLOYEE(Employee.class),
    NATURAL(NaturalEntity.class),
    LEGAL(LegalEntity.class);

    private final Class<? extends Person> entityType;

    private PersonType(Class<? extends Person> entity){
        this.entityType = entity;
    }

    public int getValue(){
        return this.ordinal();
    }

    public static PersonType byType(Class<?> type){
        return Arrays.stream(PersonType.values())
                .filter(e -> e.entityType == type)
                .findFirst()
                .orElse(NONE);
    }

}

