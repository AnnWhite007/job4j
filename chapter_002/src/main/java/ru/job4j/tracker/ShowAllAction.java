package ru.job4j.tracker;

import java.util.Arrays;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] list = tracker.findAll();
        for (int i = 0; i < list.length; i++) {
            out.println(list[i]);
        }
            return true;
    }
}
