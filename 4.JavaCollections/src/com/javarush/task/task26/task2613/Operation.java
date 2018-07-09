package com.javarush.task.task26.task2613;

/**
 * Created by User2 on 20.02.2018.
 */
public enum Operation {
    LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        try {
            if (i == 1) throw new IllegalArgumentException();
            return Operation.values()[i - 1];
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
