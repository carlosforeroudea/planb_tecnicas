package model.util;

import model.entity.Employee;
import model.entity.LegalEntity;
import model.entity.NaturalEntity;
import model.entity.Person;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public enum PersonType {
    NONE(() -> null),
    EMPLOYEE(Employee::new),
    NATURAL(NaturalEntity::new),
    LEGAL(LegalEntity::new);

    private final Supplier<? extends Person> supplier;
    private final Class<? extends Person> entityType;

    private PersonType(Supplier<? extends Person> personConstructor){
        this.supplier = personConstructor;
        this.entityType = personConstructor.get().getClass();
    }

    public int getValue(){
        return this.ordinal();
    }
    public <P extends Person> Optional<P> create(){
        return Optional.of((P) this.supplier.get());
    }

    public static PersonType byType(Class<?> type){
        return Arrays.stream(PersonType.values())
                .filter(e -> e.entityType == type)
                .findFirst()
                .orElse(NONE);
    }

}

