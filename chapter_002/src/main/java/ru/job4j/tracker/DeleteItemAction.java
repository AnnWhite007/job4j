package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Write id ====");
        int id = input.askInt("id: ");
        if (tracker.delete(id)) {
            System.out.println("=== Successfully ===="); // вывод об успешности операции
        } else {
            System.out.println("=== Error ===="); // вывод об ошибке
        }
        return true;
    }
}
