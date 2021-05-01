package ru.job4j.stream;

import java.util.List;

/**
 * 0.1. Отладка лямбда в IDEA
 * Stream конструкции принято переносить на новую строку.
 * В строке должно находиться не более 80 символов.
 */

public class StreamUsage2 {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);
    }
}
