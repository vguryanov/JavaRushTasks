package com.javarush.task.task30.task3007;

/* 
Найдем число 2 в максимальной степени
*/
public class Solution {
    public static void main(String[] args) {
//        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
//        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {
        System.out.println(Integer.toString(x,2));
        x |= x >> 1;
        System.out.println(Integer.toString(x,2));
        x |= x >> 2;
        System.out.println(Integer.toString(x,2));
        x |= x >> 4;
        System.out.println(Integer.toString(x,2));
        x |= x >> 8;
        System.out.println(Integer.toString(x,2));
        x |= x >> 8;
        System.out.println(Integer.toString(x,2));
        x |= x >> 8;
        System.out.println(Integer.toString(x,2));
        System.out.println(Integer.toString(x ^ (x >> 1),2));

        return x ^ (x >> 1);
    }
}

