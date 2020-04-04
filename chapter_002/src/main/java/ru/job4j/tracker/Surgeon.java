package ru.job4j.tracker;

public class Surgeon extends Doctor {

    private String bodyPart;

    public String getBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
        return this.bodyPart;
    }
}
