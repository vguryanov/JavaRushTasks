package com.javarush.task.task33.task3310.strategy;

/**
 * Created by User2 on 15.09.2017.
 */
public interface StorageStrategy {
    public boolean containsKey(Long key);

    public boolean containsValue(String value);

    public void put(Long key, String value);

    public Long getKey(String value);

    public String getValue(Long key);
}
