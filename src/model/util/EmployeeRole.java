package model.util;

public enum EmployeeRole {
    CONSULTANT,
    BRANCH_MANAGER,
    MANAGER;

    public int getValue(){
        return this.ordinal() + 1;
    }
}
