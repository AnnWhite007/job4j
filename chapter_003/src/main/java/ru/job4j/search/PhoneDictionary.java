package ru.job4j.search;

import java.util.ArrayList;

/**
 * 1. Телефонный справочник на базе ArrayList
 * Вернуть список всех пользователей, который содержат key в любых полях через метод String.contains.
 */

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (int index = 0; index < persons.size(); index++) {
            Person findPerson = persons.get(index);
            if (findPerson.getName().contains(key) || findPerson.getSurname().contains(key) || findPerson.getAddress().contains(key) || findPerson.getPhone().contains(key)) {
                result.add(persons.get(index));
            }
        }
        return result;
    }
}