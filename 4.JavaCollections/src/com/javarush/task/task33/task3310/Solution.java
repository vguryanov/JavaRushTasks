package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User2 on 15.09.2017.
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().testStrategy(new HashMapStorageStrategy(), 10000);
    }

    public void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testStringSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) testStringSet.add(Helper.generateRandomString());
        Shortener shortener = new Shortener(strategy);

        Date startDate = new Date();
        Set<Long> testKeySet = getIds(shortener, testStringSet);
        Date finishDate = new Date();

        Long time = finishDate.getTime() - startDate.getTime();
        Helper.printMessage(time.toString());

        startDate = new Date();
        Set<String> testStringSet2 = getStrings(shortener, testKeySet);
        finishDate = new Date();

        time = finishDate.getTime() - startDate.getTime();
        Helper.printMessage(time.toString());

        if (testStringSet.equals(testStringSet2)) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }

    public Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings) result.add(shortener.getId(s));
        return result;
    }

    public Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long l : keys) result.add(shortener.getString(l));
        return result;
    }
}
