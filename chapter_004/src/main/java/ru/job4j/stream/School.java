package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 1. Фильтрация учеников.
 * В школе пришло требование разделить 9А класс на три класса.
 * У каждого ученика есть общий балл по всем предметам.  int score;
 * score - может быть в диапазоне от 0 до 100.
 * Учеников нужно поделить на следующие группы.
 * 10А диапазон балла [70: 100],
 * 10Б диапазон балла [50: 70);
 * 10B диапазон балла (0: 50);
 */

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
      List<Student> rsl = students.stream()
               .filter(student -> predict.test(student))
               .collect(Collectors.toList());
       return rsl;
    }
}
