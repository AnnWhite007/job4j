package ru.job4j.inheritance;

/**
 * 2.4. Переопределение
 * Переопределение позволяет задать новое поведение уже существующего метода.
 * Механизм переопределения (overriding) существует только при условии наследования.
 *
 * 2.5. Аннотация @Override
 * Аннотация - это механизм,
 * позволяющий произвести дополнительные действия с вашим кодом.
 * Но никак не влияет на ваш код, ее используют другие программы.
 * @Override. Эта аннотация используется только для методов.
 * Она позволяется подтвердить работу механизма переопределения.
 * Аннотации могут объявляться над классом, полем, методом.
 */

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "name : " + name + "," + System.lineSeparator() + "body : " + body;
    }
}