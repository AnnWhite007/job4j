package ru.job4j.pojo;

import java.util.Date;

/**
 * 2.3.2 Модель данных.
 * - это объект, который используется,
 * как контейнер для примитивных или ссылочных типов данных.
 * Методы "Getter and Setter" (методы доступа - аксессоры) реализуют идею инкапсуляции для полей.
 * Мы можем произвести валидацию данных прежде чем записать или получить значения полей.
 * (позволяют загрузить и прочитать данные)
 */

public class Student {
    private String fio;
    private String group;
    private Date created;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;

    }

    @Override
    public String toString() {
        return "Student{"
                + "fio='" + fio + '\''
                + ", group='" + group + '\''
                + ", created=" + created
                + '}';
    }
}
