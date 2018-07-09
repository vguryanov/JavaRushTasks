package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.ArrayList;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        ArrayList list = (ArrayList) new Object();
    }

    public void methodThrowsNullPointerException() {
        ArrayList list = null;
        list.get(2);
    }

    public static void main(String[] args) {
    }
}
