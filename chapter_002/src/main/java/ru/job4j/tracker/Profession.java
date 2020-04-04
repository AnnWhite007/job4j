package ru.job4j.tracker;

/**
 * 1. Принципы наследования. Реализация профессий в коде.
 * задача механизма наследования помочь нам создавать объекты.
 * Чтобы наследовать один класс от другого, нужно после имени класса написать ключевое слово extends и далее указать,
 * какой класс нужно наследовать.
 */

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public String getName(String name) {
        this.name = name;
        return this.name;
    }
    public String getSurname(String surname) {
        this.surname = surname;
        return this.surname;
    }
    public String getEducation(String education) {
        this.education = education;
        return this.education;
    }
    public String getBirthday(String birthday) {
        this.birthday = birthday;
        return this.birthday;
    }
}