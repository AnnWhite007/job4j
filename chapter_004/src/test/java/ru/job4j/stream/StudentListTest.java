package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentListTest {
    @Test
    public void whenListToMap() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(10, "Surname1")
        );
        Map<String, Student> rsl = StudentList.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname4", new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }
}
