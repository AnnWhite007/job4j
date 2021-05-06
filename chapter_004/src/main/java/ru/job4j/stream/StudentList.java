package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** 4. Преобразование List в Map.
 * Для этого нужно использовать collect c аргументом Collectors.toMap.
 * Преобразовать список учеников в Map. В качестве ключа использовать фамилию ученика.
 * В качестве значение использовать объект ученика.
 */

public class StudentList {
    public static Map<String, Student> collect(List<Student> students) {
        Map<String, Student> rsl = students
                .stream()
                .distinct()
                .collect(Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student
                        )
                );
        return rsl;
    }
}
