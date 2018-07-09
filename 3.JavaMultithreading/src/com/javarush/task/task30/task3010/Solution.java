package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        int minRadix = 0;

        for (int i = 2; i < 37 && minRadix == 0; i++) {
            try {
                BigInteger b = new BigInteger(args[0], i);
                minRadix = i;
            } catch (Exception e) {

            }
        }

        if (minRadix != 0) System.out.println(minRadix);
        else System.out.println("incorrect");
    }
}