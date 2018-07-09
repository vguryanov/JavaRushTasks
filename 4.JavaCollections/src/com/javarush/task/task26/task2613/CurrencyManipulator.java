package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by User2 on 21.02.2018.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

//    public static void main(String[] args) {
//        CurrencyManipulator manipulator = new CurrencyManipulator("EUR");
//        manipulator.addAmount(200,3);
////        manipulator.addAmount(100,2);
////        manipulator.addAmount(50,3);
//        manipulator.addAmount(500,4);
//
//        System.out.println(manipulator.withdrawAmount(600));
//        System.out.println(manipulator.denominations);
//    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int result = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) result += (pair.getValue() * pair.getKey());
        return result;
    }

    public boolean hasMoney() {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> denominationsCopy = new HashMap<>(denominations);
        Map<Integer, Integer> used = new HashMap<>();

        List<Integer> denominationsList = new ArrayList<>(denominationsCopy.keySet());
        Collections.sort(denominationsList);
        Collections.reverse(denominationsList);

        int expectedResult = expectedAmount;

        for (int i = 0; i < denominationsList.size() && expectedResult > 0; i++) {
            Integer denominationKey = denominationsList.get(i);
            Integer count = denominationsCopy.get(denominationKey);

            for (int j = 0; j < denominationsCopy.get(denominationKey) && expectedResult > 0; j++) {
                if (denominationKey <= expectedResult) {
                    count--;
                    expectedResult -= denominationKey;
                } else break;
            }

            int countDiff = denominationsCopy.get(denominationKey) - count;
            if (countDiff > 0) used.put(denominationKey, countDiff);

            if (count == 0) denominationsCopy.remove(denominationKey);
            else denominationsCopy.put(denominationKey, count);
        }

        if (expectedResult != 0) throw new NotEnoughMoneyException();

        denominations = denominationsCopy;
        return used;
    }
}
