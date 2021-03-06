package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

/**
 * Created by User2 on 08.07.2017.
 */
public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {}

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) { }

    public void register(Cook cook) { cooks.add(cook); }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();
        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){

        }
    }



}