package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 3. Optional в банковских переводах.
 * В JDK 1.8 появился класс java.util.Optional.
 * Задача класса java.util.Optional - это устранить появление в программе NullPointerException.
 * Класс java.util.Optional - это обертка на null.  У класса есть два метода.
 * Чтобы обернуть null: Optional.empty();
 * Чтобы обернуть not-null: Optional.of(user)
 * Чтобы проверить, что объект не null используйте метод if (opt.isPresent()) {
 * Чтобы получить значение этого объекта:opt.get()
 */

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = students.get(s.get());
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}