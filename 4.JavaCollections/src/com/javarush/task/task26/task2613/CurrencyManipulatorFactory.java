package com.javarush.task.task26.task2613;

import java.util.*;

/**
 * Created by User2 on 21.02.2018.
 */
public class CurrencyManipulatorFactory {
    private static CurrencyManipulatorFactory factory = new CurrencyManipulatorFactory();
    private static Map<String, CurrencyManipulator> map = new HashMap();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        currencyCode = currencyCode.toUpperCase();
        
        if (!map.containsKey(currencyCode)) map.put(currencyCode, new CurrencyManipulator(currencyCode));
        return map.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return new LinkedList(map.values());
    }
}
