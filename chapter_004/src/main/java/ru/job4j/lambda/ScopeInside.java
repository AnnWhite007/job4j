package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * 4. Зона видимости в лямбда-выражениях и исключения.
 * 1. Переменная, объявленная внутри лямбда-выражения, доступна только в самом лямбда-выражении.
 * 2. Переменная, объявленная вне лямбда-выражения, доступна как внутри лямбда-выражения, так и вне его.
 * 3. Исключения в лямбда-выражениях
 */

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int t = total;
            total = add(
                    () -> t + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}