package ru.job4j.inheritance;

/**
 * @author Andrey Shulgin (neonod404@gmail.com)
 */
public class JSONReport extends TextReport{

    @Override
    public String generate(String name, String body) {
        return name + " name" + System.lineSeparator() + body + " body";
    }
}
