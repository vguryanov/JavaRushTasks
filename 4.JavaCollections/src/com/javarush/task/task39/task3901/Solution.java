package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        else {
            ArrayList<Integer> lengthlist = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                Set<Character> charList = new LinkedHashSet<>();

                for (int j = 0; j < s.length() - i; j++) {
                    if (charList.contains(s.charAt(j + i))) {
                        lengthlist.add(j);
                        break;
                    } else {
                        if (i + j + 1 == s.length()) lengthlist.add(j + 1);
                        else charList.add(s.charAt(i + j));
                    }
                }
            }

            Collections.sort(lengthlist);
            Collections.reverse(lengthlist);
            return lengthlist.get(0);
        }
    }
}
