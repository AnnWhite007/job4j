package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 0. Stream API улучшения
 * Stream.takeWhile - этот метод позволяет получать поток данных до тех пор, пока условие истина.
 * Stream.dropWhile - этот метод позволяет получать поток данных после того, как условие стало ложным.
 * Stream.ofNullable - сделает из элемента поток, если элемент равен null, то элемент пропускается.
 */

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}