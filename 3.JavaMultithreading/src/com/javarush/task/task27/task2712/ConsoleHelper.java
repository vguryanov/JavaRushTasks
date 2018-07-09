package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User2 on 24.04.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> order = new ArrayList<>();
        String choice = "";
        writeMessage(Dish.allDishesToString() + "\nПожалуйста, выберите блюдо:");

        while (true) {
            choice = bufferedReader.readLine();
            if (choice.equals("exit")) break;

            try{
                order.add(Dish.valueOf(choice));
            }catch (IllegalArgumentException e){
                ConsoleHelper.writeMessage("Такое блюдо отсутствует в меню");
            }
        }

        return order;
    }
}
