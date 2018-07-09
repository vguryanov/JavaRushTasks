package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    public static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();
        String s;

        try {
            int t = Integer.parseInt(number);

            for (int i = 2; i <= 36; i++) {
                try {
                    s = Integer.toString(t, i);
                    if (s.equals(new StringBuffer(s).reverse().toString())) result.add(i);
                } catch (NumberFormatException e) {
                }
            }
        } catch (NumberFormatException e) {
        }

        return result;
    }

    private static Set<Integer> getaRadix(String number){
        Set<Integer> list = new HashSet<>();
        int count;
        try{
            count = Integer.parseInt(number);
            for(int i = 2; i < 37; i++){
                try{
                    String line = Integer.toString(count, i);
                    if (line.equals(new StringBuffer(line).reverse().toString())) list.add(i);
                }catch(NumberFormatException e){
                }
            }
        }catch (NumberFormatException e) {
        }
        return list;
    }
}