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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        // Создаем объект tracker
        Tracker tracker = new Tracker();
        // Добавим в tracker новую заявку - item. После этой операции у нас есть id
        Item item = tracker.add(new Item("Replaced item"));
        // Входные данные должны содержать ID добавленной заявки item.getId()
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ReplaceItemAction(out));
                actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }


    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        // Добавим в tracker новую заявку
        Item item = tracker.add(new Item("Deleted item"));
        // Входные данные должны содержать ID добавленной заявки item.getId()
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new DeleteItemAction(out));
                actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                //  0 - это пункт меню "Создать новую заявку"
                //"Item name" - это будет имя новой заявки.
                //1 - это пункт меню "Выйти".
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        // Показать меню
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new ExitAction());
        // Выбрать пункт "Создание заявки", Выбрать пункт "Выйти"
        new StartUI(out).init(in, tracker, actions);
        // Проверить, что в объект Tracker появилась новая заявка с именем "Item name"
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        // Добавим в tracker новую заявку
        tracker.add(new Item("first item"));
        tracker.add(new Item("second item"));
        tracker.add(new Item("third item"));
        Input in = new StubInput(
                //  0 - это пункт меню "Создать новую заявку"
                //"Item name" - это будет имя новой заявки.
                //1 - это пункт меню "Выйти".
                new String[] {"0", "1"}
        );
        // Показать меню
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ShowAllAction(out));
                actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
                + "id: 1, name: first item" + System.lineSeparator()
                + "id: 2, name: second item" + System.lineSeparator()
                + "id: 3, name: third item" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        // Добавим в tracker новую заявку
        tracker.add(new Item("first item"));
        tracker.add(new Item("second item"));
        tracker.add(new Item("second item"));
        Input in = new StubInput(
                //  0 - это пункт меню "Создать новую заявку"
                //"Item name" - это будет имя новой заявки.
                //1 - это пункт меню "Выйти".
                new String[] {"0", "second item", "1"}
        );
        // Показать меню
        List<UserAction> actions = new ArrayList<>();
                actions.add(new FindItemByNameAction(out));
                actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
                + "=== Write search name ====" + System.lineSeparator()
                + "id: 2, name: second item" + System.lineSeparator()
                + "id: 3, name: second item" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        // Добавим в tracker новую заявку
        tracker.add(new Item("third item"));
        tracker.add(new Item("fourth item"));
        Input in = new StubInput(
                //  0 - это пункт меню "Создать новую заявку"
                //"Item name" - это будет имя новой заявки.
                //1 - это пункт меню "Выйти".
                new String[] {"0", "2", "1"}
        );
        // Показать меню
        List<UserAction> actions = new ArrayList<>();
                actions.add(new FindItemByIdAction(out));
                actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
                + "=== Write id ====" + System.lineSeparator()
                + "id: 2, name: fourth item" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
        ));
    }
    // тест на сценарий, где пользователь вводит сначала несуществующий пункт, а потом верный
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"5", "0" }
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit Program%n"
                )
        ));
    }
}
