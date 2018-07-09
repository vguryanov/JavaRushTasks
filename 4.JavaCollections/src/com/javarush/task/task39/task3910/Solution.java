package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        else if (n == 1) return true;

        while (n % 3 == 0) {
            n /= 3;
            if (n == 1) return true;
        }

        return false;
    }
}
