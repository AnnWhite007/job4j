package ru.job4j.search;

import java.util.LinkedList;

/**
 * 2. Очередь с приоритетом на LinkedList - этот класс внутри использует связанные списки.
 * В Java коллекции представляют собой фреймворк/набор классов, которые можно легко расширить.
 * Если ячейка уже занята, то элементы сдвигаются вправо, а не заменяются, как в массиве.
 *
 * Очередь с приоритетами - это коллекция,
 * в которой элементы при добавлении располагаются в определенном порядке.
 * Метод должен вставлять в нужную позицию элемент.
 * Позиция определяется по полю приоритет.
 * Для вставки использовать add(int index, E value)
 *
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    // В методе put вам нужно найти index нужного элемента
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    //Метод take возвращает первый элемент из списка и удаляет его
    public Task take() {
        return tasks.poll();
    }
}
