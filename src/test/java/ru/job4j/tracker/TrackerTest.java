package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNull;
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
    public void whenAddNewItemsThenFindAllItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        tracker.add(new Item("test2"));
        Item[] result = tracker.findAll();
        assertThat(result[1].getName(), is("test2"));
    }

    @Test
    public void whenAddNewItemsThenFindByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        tracker.add(new Item("test2"));
        Item[] result = tracker.findByName("test3");
        assertNull(result);
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDelete2() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item notBug = new Item("Dont Bug");
        tracker.add(bug);
        tracker.add(notBug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
        assertThat(tracker.findAll().length, is(1));
        assertThat(tracker.findByName("Dont Bug")[0].getName(), is(notBug.getName()));
    }
}