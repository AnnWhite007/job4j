package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2. Аттестация
 * Класс Analyze получает статистику по аттестатам.
 */

public class Analyze {
    /** Метод вычисляет общий средний балл. */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(s -> s.getScore())
                .average()
                .orElse(0D);
    }

    /** Метод вычисляет средний балл ученика по его предметам.
     * @return возвращает имя ученика и средний балл
     */
     public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D)))
                .collect(Collectors.toList());
    }

    /** Метод вычисляет средний балл по всем предметам для каждого ученика.
     * @return возвращает название предмета и средний балл
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    /** Метод bestStudent - возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам. */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /** Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     * @return возвращает имя предмета, сумма баллов каждого ученика по этому предмету
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}