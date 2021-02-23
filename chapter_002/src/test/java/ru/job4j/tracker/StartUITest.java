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
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenReplaceItem() {
        // Создаем объект tracker
        Tracker tracker = new Tracker();
        // Добавим в tracker новую заявку - item. После этой операции у нас есть id
        Item item = tracker.add(new Item("Replaced item"));
        // Входные данные должны содержать ID добавленной заявки item.getId()
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItemAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }


    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                //  0 - это пункт меню "Создать новую заявку"
                //"Item name" - это будет имя новой заявки.
                //1 - это пункт меню "Выйти".
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        // Показать меню
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        // Выбрать пункт "Создание заявки", Выбрать пункт "Выйти"
        new StartUI().init(in, tracker, actions);
        // Проверить, что в объект Tracker появилась новая заявка с именем "Item name"
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
}
