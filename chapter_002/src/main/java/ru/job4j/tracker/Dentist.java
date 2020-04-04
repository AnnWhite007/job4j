package ru.job4j.tracker;

public class Dentist extends Doctor {

    private String operationType;

    public String getOperationType(String operationType) {
        this.operationType = operationType;
        return this.operationType;
    }
}
