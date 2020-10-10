package ru.job4j.inheritance;

/**
 * 2.4. Переопределение
 * Переопределение позволяет задать новое поведение уже существующего метода.
 * Механизм переопределения (overriding) существует только при условии наследования.
 */

public class JSONReport extends TextReport {

    public String generate(String name, String body) {
        return "name : " + name + "," + System.lineSeparator() + "body : " + body;
    }
}
