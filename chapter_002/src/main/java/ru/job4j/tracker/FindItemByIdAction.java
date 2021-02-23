package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Write id ====");
        int id = input.askInt("id: ");
        Item findId = tracker.findById(id);
        if (findId == null) {
            System.out.println("=== Application with this id was not found ===="); // вывод об ошибке
        } else {
            System.out.println(findId); // вывод результата операции
        }
        return true;
    }
}
