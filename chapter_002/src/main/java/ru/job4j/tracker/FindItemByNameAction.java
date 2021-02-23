package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Write search name ====");
        String findName = input.askStr("search name: ");
        Item[] listFindName = tracker.findByName(findName);
        if (listFindName.length == 0) {
            out.println("=== Applications with this name was not found ===="); // вывод об ошибке
        } else {
            for (int i = 0; i < listFindName.length; i++) {
                out.println(listFindName[i]);
            }
        }
        return true;
    }
}
