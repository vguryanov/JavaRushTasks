package com.javarush.task.task35.task3505;

public class ConvertableBook extends Convert {
    private String name;

    public ConvertableBook(String name) {
        this.name = name;
    }

    @Override
    public String getKey() {
        return name;
    }

    @Override
    public String toString() {
        return "ConvertableBook{" +
                "name='" + name + '\'' +
                '}';
    }
}
