package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by User2 on 24.04.2017.
 */
public class Order {

    private Tablet tablet;
    private List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();

    }


    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        }
        else {
            return "Your order: " + dishes.toString() +" of "+  tablet.toString();
        }

    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {

        int totalTime = 0;

        for (int i = 0; i < dishes.size(); i++) {
            totalTime = dishes.get(i).getDuration() + totalTime;
        }

        return totalTime;

    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}