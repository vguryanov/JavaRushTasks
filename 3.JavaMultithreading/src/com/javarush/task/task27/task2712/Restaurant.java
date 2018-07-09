package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * Created by User2 on 24.04.2017.
 */
public class Restaurant {
    public static void main(String[] args) {
        Cook cook1 = new Cook("Joe");
        Waiter waiter1 = new Waiter();
        Tablet tablet1 = new Tablet(1);

        cook1.addObserver(waiter1);
        tablet1.addObserver(cook1);

        try {
            tablet1.createOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
