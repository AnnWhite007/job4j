package ru.job4j.tracker;

/**
 * 5.1. Тестирование. Подготовка данных.
 * Тестирование можно разбить на три группы:
 * - тестирование черным ящиком - мы не знаем, что находится внутри. Создание теста делаем на основании документации.
 * - тестирование серым ящиком - доступна документация и часть кода.
 * - тестирование прозрачным (стеклянным) ящиком - доступен весь код
 * Группы отличаются друг от друга степенью доступности содержимого кода.
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        // Создаем объект tracker
        Tracker tracker = new Tracker();
        // Создаем объект item
        Item item = new Item("new item");
        // Добавляем item в tracker. После этой операции у нас есть id
        tracker.add(item);
        // Достаем item.id и создаем массив с ответами пользователя
        String[] answers = {
                String.valueOf(item.getId()), "replaced item"/* id сохраненной заявки в объект tracker. */
        };
        // Вызываем тестируемый метод replaceItem. Это действие изменит состояние объекта tracker
        StartUI.replaceItem(new StubInput(answers), tracker);
        // Ищем по item.id замененный item в объекте tracker
        Item replaced = tracker.findById(item.getId());
        // Сравниваем имя найденной заявки с ожидаемой
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item2");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }
}