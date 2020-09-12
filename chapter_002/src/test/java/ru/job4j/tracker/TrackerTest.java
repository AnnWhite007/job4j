package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2");
        tracker.add(item);
        Item []result = tracker.findAll();
        assertThat(result[0].getName(), is(item.getName()));
    }

    @Test
    public void ifFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test3");
        tracker.add(item);
        Item []result = tracker.findByName(item.getName());
        assertThat(result[0].getName(), is(item.getName()));
    }
}

//Для findAll и для findByName
