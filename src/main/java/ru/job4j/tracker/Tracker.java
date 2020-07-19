package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * Метод добавляет заявку в трекер.
     *
     * @param item - заявка
     * @return - добавленная заявка
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Метод ищет в трекере заявку по Id.
     *
     * @param id - искомое Id.
     * @return - возвращает заявку, если заявка не найдено, то null.
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Метод ищет в трекере заданное имя заявки
     *
     * @param key - имя заявки
     * @return - Список заявок с заданным именем или null, если таких заявок нет
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int sz = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                result[sz++] = items[index];
            }
        }
        if (sz == 0) {
            result = null;
        } else {
            result = Arrays.copyOf(result, sz);
        }
        return result;
    }

    /**
     * Метод возвращает весь список заявок
     *
     * @return - список заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Метод заменяет заявку в трекере
     *
     * @param id   - id заявки в трекере
     * @param item - новая заявка
     * @return - true если заявка с таким id была найдена и заменена, false если нет
     */
    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            int oldId = items[index].getId();
            items[index] = item;
            items[index].setId(oldId);
            result = true;
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}