package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 5. Преобразование матрицы чисел в список чисел.
 * Чтобы преобразовать список списков нужно использовать flatMap()
 * -  принимает элемент потока и преобразовывает его в новый поток.
 */

public class Matrix {
    public static List<Integer> toList(Integer[][] matritsa) {
        List<Integer> rsl = Arrays.stream(matritsa)
                .flatMap(e -> Arrays.stream(e))
                .collect(Collectors.toList());
        return rsl;
    }
}
