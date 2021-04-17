package ru.job4j.collection;

import java.util.Objects;

/**
 * 1. Организовать сортировку User
 * В Java есть интерфейс java.util.Set. Классы этого интерфейса - это java.util.HashSet и java.util.TreeSet.
 * Они не содержат дубликатов.
 * TreeSet требует от входящего типа данных поддержания интерфейса java.util.Comparable.
 * При каждой вставке в TreeSet элемент будет искать нужную ячейку через механизм сравнения элементов.
 * Внутри TreeSet используется бинарное дерево поиска.
 * Когда нам нужно расположить элементы по убыванию, в конструктор коллекции нужно передать компаратор.
 *
 * В модели должны быть поля: имя и возраст.
 * Предусмотреть ситуацию, когда два пользователя имеют одинаковое имя.
 * В этом случае нужно сравнить их возраст.
 */

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        if (name.equals(o.name)) {
        return Integer.compare(age, o.age);
        }
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
