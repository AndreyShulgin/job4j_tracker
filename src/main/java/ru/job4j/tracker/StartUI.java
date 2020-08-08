package ru.job4j.tracker;


/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */
public class StartUI {


    /**
     * Метод работает с меню предложения
     *
     * @param input   - объект ввода данных с консоли
     * @param tracker - объект работы с методами трекера
     */
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Выберете: ");
            int select = input.askInt("Выберете: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItem(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    /**
     * Создание заявки
     *
     * @param input   - ввод данных
     * @param tracker - объект хранилища заявок
     */
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Создание заявки ====");
        String name = input.askStr("Введите название: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    /**
     * Поиск заявок
     *
     * @param input   - ввод данных
     * @param tracker - объект хранилища заявок
     */
    public static void findAllItem(Input input, Tracker tracker) {
        System.out.println("==== Список заявок =====");
        Item[] items = tracker.findAll();
        for (Item itm : items) {
            System.out.println(itm.getName());
        }
    }

    /**
     * Редактирование заявки
     *
     * @param input   - ввод данных
     * @param tracker - объект хранилища заявок
     */
    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("==== Редактор заявок ====");
        int id = input.askInt("Введите ID заявки для изменения: ");
        Item item = new Item(input.askStr("Введите новое описание заявки: "));
        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Заявка с таким ID не найдена, повторите попытку.");
        }
    }

    /**
     * Удаление заявки
     *
     * @param input   - ввод данных
     * @param tracker - объект хранилища заявок
     */
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Удаление заявки ====");
        int id = input.askInt("Введите ID заявки для удаления: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка с таким ID не найдена, повторите попытку.");
        }
    }

    /**
     * Поиск заявки по Id
     *
     * @param input   - ввод данных
     * @param tracker - объект хранилища заявок
     */
    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("==== Поиск заявок ====");
        int id = input.askInt("Введите ID искомой заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Описание заявки: " + System.lineSeparator() + item.getName());
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    /**
     * Поиск заявки по имени
     *
     * @param input   - ввод данных
     * @param tracker - объект хранилища заявок
     */
    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("==== Поиск заявок ====");
        Item[] items = tracker.findByName(input.askStr("Введите название искомой заявки: "));
        if (items != null) {
            System.out.println("ID заявок: ");
            for (Item item : items) {
                System.out.println(item.getId());
            }
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    private void showMenu() {
        System.out.println("Меню." + System.lineSeparator() +
                "0. Добавление новой заявки" + System.lineSeparator() +
                "1. Показать все заявки" + System.lineSeparator() +
                "2. Редактирование заявки" + System.lineSeparator() +
                "3. Удаление заявки" + System.lineSeparator() +
                "4. Поиск заявки по Id" + System.lineSeparator() +
                "5. Поиск заявки по названию" + System.lineSeparator() +
                "6. Выход из программы"
        );
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
