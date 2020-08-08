package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}