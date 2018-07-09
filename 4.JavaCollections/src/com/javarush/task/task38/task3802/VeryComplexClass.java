package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileInputStream;

public class VeryComplexClass {
    public int veryComplexMethod() {
        try {
            return 1;
        } finally {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new VeryComplexClass().veryComplexMethod());
    }
}
