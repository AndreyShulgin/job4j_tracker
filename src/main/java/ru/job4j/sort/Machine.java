package ru.job4j.sort;

import java.util.Arrays;

/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int temp = money - price;
        for (int coin : COINS) {
            while (temp - coin >= 0) {
                rsl[size++] = coin;
                temp = temp - coin;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}