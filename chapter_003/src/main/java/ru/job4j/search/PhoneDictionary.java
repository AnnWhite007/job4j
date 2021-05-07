package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;


/**
 * 1. Телефонный справочник на базе ArrayList
 * Вернуть список всех пользователей, который содержат key в любых полях через метод String.contains.
 * 6. Функции высшего порядка
 * Функции высшего порядка - это функции, зависящие от других функций.
 */

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = p -> p.getName().contains(key);
        Predicate<Person> bySurname = p -> p.getSurname().contains(key);
        Predicate<Person> byAddress = p -> p.getAddress().contains(key);
        Predicate<Person> byPhone = p -> p.getPhone().contains(key);
        Predicate<Person> combine = byName
                .or(bySurname)
                .or(byAddress)
                .or(byPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

/*
        ArrayList<Person> result = new ArrayList<>();
        for (Person value : persons) {
            if (value.getName().contains(key) || value.getSurname().contains(key)
                    || value.getAddress().contains(key)
                    || value.getPhone().contains(key)) {
                result.add(value);
            }
        }
        return result;
    }
 */
}