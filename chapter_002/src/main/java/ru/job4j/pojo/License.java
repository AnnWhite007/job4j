package ru.job4j.pojo;

/**
 * 4. Сравнение моделей. Метод equals
 * Чтобы проверить, что два объекта типа Product равны, нужно использовать метод equals.
 * Мы не можем сравнивать ссылочные типы через оператор равенства ==,
 * потому что данные ссылочных типов хранятся не сразу в переменной, а в разделе памяти HEAP
 * Метод equals определен в базовом классе java.lang.Object.
 * Он работает так же, как и оператор ==.
 * Чтобы метод equals работал правильно, нужно его переопределить для класса
 * Сгенерировать метод equals: Code - Generate - equals and hashCode
 */

import java.util.Date;
import java.util.Objects;

public class License {
    private String owner;
    private String model;
    private String code;
    private Date created;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        License license = (License) o;
        return Objects.equals(owner, license.owner)
                && Objects.equals(model, license.model)
                && Objects.equals(code, license.code)
                && Objects.equals(created, license.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, model, code, created);
    }
}