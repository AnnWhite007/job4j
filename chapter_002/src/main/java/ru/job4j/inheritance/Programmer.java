package ru.job4j.inheritance;

import ru.job4j.inheritance.Engineer;

public class Programmer extends Engineer {

    private String language;

    public String getLanguage(String language) {
        this.language = language;
        return this.language;
    }
}
