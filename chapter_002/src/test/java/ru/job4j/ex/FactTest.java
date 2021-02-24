package ru.job4j.ex;
/**
 * 0.3. Тестирование исключений с junit
 * Если нам нужно проверить ситуацию, когда программа прерывается с исключением
 * нам нужно в аннотации @Test указать класс исключения.
 */

import org.junit.Test;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenLessThen0() {
        Fact.calc(-2);
    }
}
