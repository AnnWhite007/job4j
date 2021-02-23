package ru.job4j.tracker;

/**
 * 2.1. Реализация класса StartUI
 * Консольное приложение для работы с классом ru.job4j.tracker.Tracker.
 * Вместо вызова scanner.nextLine() - input.askStr(msg), где msg - это сообщение,
 * которое вы хотели бы вывести пользователю перед его вводом
 * 4.2. Статические методы.
 * - это методы привязанные к классу, а не к объекту (static).
 * разбиваем код на функциональные блоки
 * 8. Реализация меню за счет шаблона стратегия.
 * Если мы разорвем зависимость от конкретных действия в StartUI,
 * то мы сможем добавлять новые действия без изменения существующего кода.
 * В StartUI нам нужен массив действий.
 * Каждая ячейка у нас будет одно действие.
 * Такая структура описывает наше меню.
 */
public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            // вывод меню
            this.showMenu(actions);
            // получаем от пользователя пункт меню, этот параметр мы используем в качестве индекса в массиве actions
            int select = input.askInt("Select: ");
            // получение данных из массива
            UserAction action = actions[select];
            // У полученного объекта вызываем метод execute с передачей параметров input и tracker
            run = action.execute(input, tracker);
        }
    }

    //отвечает за вывод пунктов меню
    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    // при запуске пользователю отображается меню в консоли
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        // создаем массив с действиями
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new ReplaceItemAction(output),
                new DeleteItemAction(output),
                new FindItemByIdAction(output),
                new FindItemByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}