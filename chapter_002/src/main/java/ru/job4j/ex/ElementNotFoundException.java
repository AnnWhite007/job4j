package ru.job4j.ex;

/**
 * Класс java.lang.Exception имеет конструктор по умолчанию.
 * всегда добавлять конструктор с текстом.
 */

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String message) {
        super(message);
    }
}
