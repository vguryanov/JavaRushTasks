package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int i = 1;
        System.out.println(i);
        System.out.println(Integer.toString(i, 2));
        System.out.println(Integer.toString(i<<6, 2));

//        Solution solution = new Solution();
//        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        final int[] constants = {1, 3, 9, 27, 81, 243, 729, 2187};
        String s = Integer.toString(number, 3);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++)
            list.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        Collections.reverse(list);

        String result = number + " =";

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                int sign = Math.abs(list.get(i)) / list.get(i);

                if (list.get(i) == 2 || list.get(i) == -2) {
                    list.set(i, sign * -1);

                    if (list.size() - 1 < i + 1) list.add(0);
                    list.set(i + 1, list.get(i + 1) + sign);
                }

                if (list.get(i) == 3 || list.get(i) == -3) {
                    list.set(i, 0);

                    if (list.size() - 1 < i + 1) list.add(0);
                    list.set(i + 1, list.get(i + 1) + sign);
                }

                if (list.get(i) != 0)
                    result += (Math.abs(list.get(i)) / list.get(i) > 0 ? " + " : " - ") + Math.abs(list.get(i) * (int) Math.pow(3, i));
            }
        }

        System.out.println(result);
    }
}

//        0000001
//        1000000