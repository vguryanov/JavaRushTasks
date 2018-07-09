package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("jhlh"));
    }

    public static boolean isPalindromePermutation(String s) {
        HashSet<Character> charSet = new HashSet<>();
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) charSet.remove(c);
            else charSet.add(c);
        }

        return charSet.size() == 0 || charSet.size() == 1 ? true : false;
    }
}
