package ru.job4j.condition;

/**
 * 4.1. Глупый бот.
 * Бот должен принимать строку и возвращать ответ.
 */

public class DummyBot {

    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}