package ru.job4j.tracker;

public class Programmer extends Engineer {

    private String language;

    public String getLanguage(String language) {
        this.language = language;
        return this.language;
    }
}
