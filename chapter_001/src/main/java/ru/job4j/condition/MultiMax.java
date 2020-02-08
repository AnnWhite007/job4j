package ru.job4j.condition;

/**
 * 4.4. Максимум из трех чисел.
 * Метод должен возвращать максимум из трех чисел.
 * Сравнить попарно первое со вторым и максимум из них сравнить с третьим числом.
 */

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        result = result > third ? result : third;
        return result;
    }
}