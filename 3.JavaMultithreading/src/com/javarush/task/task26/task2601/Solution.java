package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        int med;

        if (array.length % 2 == 0) med = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else med = array[array.length / 2];

        class MedComprtr implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer i1 = o1 - med;
                if (i1 < 0) i1 = -i1;
                Integer i2 = o2 - med;
                if (i2 < 0) i2 = -i2;

                return Integer.compare(i1, i2);
            }
        }

        Arrays.sort(array, new MedComprtr());

        return array;
    }
}
