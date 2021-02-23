package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Write id ====");
        int id = input.askInt("id: ");
        System.out.println("=== Write new name ====");
        String newName = input.askStr("name: ");
        Item newItem = new Item(newName);
        if (tracker.replace(id, newItem)) {
            System.out.println("=== Successfully ===="); // вывод об успешности операции
        } else {
            System.out.println("=== Error ===="); // вывод об ошибке
        }
        return true;
    }
}
