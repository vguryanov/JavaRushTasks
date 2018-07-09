package com.javarush.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }



    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis ("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;
        Company(String name) {
            this.fullName = name;
        }
    }
}
