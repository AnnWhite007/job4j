package ru.job4j.tracker;

/**
 * 2.1. Реализация класса StartUI
 * Консольное приложение для работы с классом ru.job4j.tracker.Tracker.
 * Вместо вызова scanner.nextLine() - input.askStr(msg), где msg - это сообщение,
 * которое вы хотели бы вывести пользователю перед его вводом
 */
public class StartUI {
//  В зависимости от введенного пункта нужно отработать ситуации по пунктам меню.
    public void init(Input input, Tracker tracker) {
        boolean run = false;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item list[] = tracker.findAll();
                for (int i = 0; i < list.length; i++) {
                    System.out.println(list[i]);
                }
            } else if (select == 2) {
                System.out.println("=== Write id ====");
                int id = Integer.valueOf(input.askStr("id: "));
                System.out.println("=== Write new name ====");
                String newname = input.askStr("name: ");
                Item newItem = new Item(newname);
                if (tracker.replace(id, newItem)) {
                    System.out.println("=== Successfully ===="); // вывод об успешности операции
                } else {
                    System.out.println("=== Error ===="); // вывод об ошибке
                }
            } else if (select == 3) {
                System.out.println("=== Write id ====");
                int id = Integer.valueOf(input.askStr("id: "));
                if (tracker.delete(id)) {
                    System.out.println("=== Successfully ===="); // вывод об успешности операции
                } else {
                    System.out.println("=== Error ===="); // вывод об ошибке
                }
            } else if (select == 4) {
                System.out.println("=== Write id ====");
                int id = Integer.valueOf(input.askStr("id: "));
                if (tracker.findById(id) == null) {
                    System.out.println("=== Application with this id was not found ===="); // вывод об ошибке
                } else {
                    System.out.println(tracker.findById(id)); // вывод результата операции
                }
            } else if (select == 5) {
                System.out.println("=== Write search name ====");
                String findName = input.askStr("search name: ");
                Item[] listFindName = tracker.findByName(findName);
                if (listFindName.length == 0) {
                    System.out.println("=== Applications with this name was not found ===="); // вывод об ошибке
                } else {
                    for (int i = 0; i < listFindName.length; i++) {
                        System.out.println(listFindName[i]);
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }
        //отвечает за вывод пунктов меню
        private void showMenu() {
            System.out.println("Menu.");
            System.out.println("0. Add new Item");
            System.out.println("1. Show all items");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit Program");
        }

        // при запуске пользователю отображается меню в консоли
        public static void main(String[] args) {
            Input input = new ConsoleInput();
            Tracker tracker = new Tracker();
            new StartUI().init(input, tracker);
        }
}