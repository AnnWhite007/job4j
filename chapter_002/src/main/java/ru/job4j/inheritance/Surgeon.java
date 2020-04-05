package ru.job4j.inheritance;

import ru.job4j.inheritance.Doctor;

public class Surgeon extends Doctor {

    private String bodyPart;

    public String getBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
        return this.bodyPart;
    }
}
