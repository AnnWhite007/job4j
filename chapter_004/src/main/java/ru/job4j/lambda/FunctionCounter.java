package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 5. Подсчет функции в диапазоне.
 * Реализовать метод подсчета функции в диапазоне.
 *     - линейная.
 *     - квадратичная.
 *     - показательная. (y = a^x, где a - постоянная)
 */

public class FunctionCounter {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<Double>();
        for (double i = start; i < end; i++) {
            rsl.add(func.apply(i));
        }
        return rsl;
    }
}
