package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int result = 0;
        ArrayList<Integer> decimalNums = new ArrayList<>();
        Map<Character, Integer> transcript = new HashMap<>();
        transcript.put('I', 1);
        transcript.put('V', 5);
        transcript.put('X', 10);
        transcript.put('L', 50);
        transcript.put('C', 100);
        transcript.put('D', 500);
        transcript.put('M', 1000);

        for (Character character : s.toUpperCase().toCharArray()) decimalNums.add(transcript.get(character));

        for (int i = 0; i < decimalNums.size(); i++) {
            if (i < decimalNums.size() - 1 && decimalNums.get(i + 1) > decimalNums.get(i)) {
                result += decimalNums.get(i + 1) - decimalNums.get(i);
                i++;
            } else result += decimalNums.get(i);
        }

        return result;
    }
}
