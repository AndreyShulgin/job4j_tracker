package ru.job4j.io;

import java.util.Scanner;

/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */
public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        System.out.println("На столе лежит " + matches + " спичек.");
        while (matches > 0) {
            System.out.println("Возьмите от 1 до 3 спичек");
            int number = Integer.parseInt(input.nextLine());
            if (number > 0 && number < 4 && number <= matches) {
                matches = matches - number;
                System.out.println("На столе осталось " + matches + " спичек");
            } else {
                System.out.println("Вы взяли не правильное количество спичек, повторите попытку.");
            }
            if (matches == 0) {
                System.out.println("Поздравляем! Вы победили!");
            }
        }
    }
}
