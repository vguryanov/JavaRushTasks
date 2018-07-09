package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by User2 on 24.04.2017.
 */
public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        String s = "";
        for (Dish d : Dish.values()) s += d + ", ";
        s = s.substring(0, s.length() - 2);
        return s;
    }
}
