package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from+1, to);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(1, n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) System.out.println(getRandomIntegerBetweenNumbers(1, 3));
    }
}
