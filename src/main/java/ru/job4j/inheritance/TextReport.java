package ru.job4j.inheritance;

/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */
public class TextReport {

    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}