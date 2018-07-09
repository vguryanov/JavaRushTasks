package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 1;
//        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        System.out.println(Integer.toString(number, 2));
        System.out.println(" " + Integer.toString(number >> 1, 2));

        number = number | number >> 1;
        System.out.println(Integer.toString(number, 2));

        number = number | number >> 2;
        System.out.println(Integer.toString(number, 2));

        System.out.println(Integer.toString(number, 2));
        System.out.println("" + Integer.toString(number >> 4, 2));

        number = number | number >> 4;
        System.out.println(Integer.toString(number, 2));
        number = number | number >> 8;
        System.out.println(Integer.toString(number, 2));
        number = number | number >> 16;
        System.out.println(Integer.toString(number, 2));
        return (number & ~(number >> 1));
    }
}