package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */
public class StartUI {

    /**
     * Метод работает с меню предложения
     *
     * @param scanner - объект ввода данных с консоли
     * @param tracker - объект работы с методами трекера
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Выберете: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Создание заявки ====");
                System.out.print("Введите название: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("==== Список заявок =====");
                Item[] items = tracker.findAll();
                for (Item itm : items) {
                    System.out.println(itm.getName());
                }
            } else if (select == 2) {
                System.out.println("==== Редактор заявок ====");
                System.out.println("Введите ID заявки для изменения: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите новое описание заявки: ");
                Item item = new Item(scanner.nextLine());
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка успешно изменена.");
                } else {
                    System.out.println("Заявка с таким ID не найдена, повторите попытку.");
                }
            } else if (select == 3) {
                System.out.println("==== Удаление заявки ====");
                System.out.println("Введите ID заявки для удаления: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Заявка успешно удалена.");
                } else {
                    System.out.println("Заявка с таким ID не найдена, повторите попытку.");
                }
            } else if (select == 4) {
                System.out.println("==== Поиск заявок ====");
                System.out.println("Введите ID искомой заявки: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Описание заявки: " + System.lineSeparator() + item.getName());
                } else {
                    System.out.println("Заявка не найдена.");
                }
            } else if (select == 5) {
                System.out.println("==== Поиск заявок ====");
                System.out.println("Введите название искомой заявки: ");
                Item[] items = tracker.findByName(scanner.nextLine());
                if (items != null) {
                    System.out.println("ID заявок: ");
                    for (Item item : items) {
                        System.out.println(item.getId());
                    }
                } else {
                    System.out.println("Заявка не найдена.");
                }
            } else if (select == 6) {
                run = false;
            }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
