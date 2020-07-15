package ru.job4j.oop;

/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */
public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(3);
        first.exchange(second);
        System.out.println("first = " + first.load);
        System.out.println("second = " + second.load);
    }
}
