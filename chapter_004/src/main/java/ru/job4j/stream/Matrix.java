package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 5. Преобразование матрицы чисел в список чисел.
 * Чтобы преобразовать список списков нужно использовать flatMap()
 * -  принимает элемент потока и преобразовывает его в новый поток.
 */

public class Matrix {
    public static List<Integer> toList(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
