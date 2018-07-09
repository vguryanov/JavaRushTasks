package com.javarush.task.task39.task3909;

import java.util.ArrayList;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("sds", "sd"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        else {
            String longerString;
            String shorterString;
            boolean equalLength = false;

            if (first.length() == second.length()) equalLength = true;

            if (first.length() > second.length()) {
                longerString = first;
                shorterString = second;
            } else {
                longerString = second;
                shorterString = first;
            }

            int diff = 0;

            for (int i = 0, j = 0; diff < 2 && i < longerString.length(); i++, j++) {
                if (j < shorterString.length()) {
                    if (longerString.charAt(i) != shorterString.charAt(j)) {
                        diff++;
                        if (!equalLength) j--;
                    }
                } else diff++;
            }

            if (diff < 2) return true;

//            ArrayList<Character> longerList = new ArrayList<>();
//            ArrayList<Character> shorterList = new ArrayList<>();
//            for (Character c : longerString.toCharArray()) longerList.add(c);
//            for (Character c : shorterString.toCharArray()) shorterList.add(c);

//            for (Character c : shorterString.toCharArray()) {
//                longerList.remove(c);
//                shorterList.remove(c);
//            }
//
//            if (longerList.size() == 1 || longerList.size() == 0) return true;
        }

        return false;
    }
}
