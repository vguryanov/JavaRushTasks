package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String s = new String(Files.readAllBytes(Paths.get(args[0])), Charset.defaultCharset());
        TreeSet<Character> set = new TreeSet<>();

        for (Character c : s.toLowerCase().toCharArray()) {
            if (c.toString().matches("[a-z]")) set.add(c);
        }

        ArrayList<Character> result = new ArrayList<>(set);
        Collections.sort(result);

        for (int i = 0; i < 5 && i < result.size(); i++) System.out.print(result.get(i));
    }
}
