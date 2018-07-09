package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 0, 1}
        };

        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int twoHitCorners = 0;
        int threeHitCorners = 0;
        int wholes = 0;

        for (int i = 0, j = 0; i < a.length && j < a[i].length; j++) {
            if (a[i][j] == 1) {
                int hits = 0;
                boolean rightHit = false;
                boolean leftHit = false;
                boolean upperHit = false;
                boolean lowerHit = false;

                if (j == 0 || a[i][j - 1] == 0) {
                    leftHit = true;
                    hits++;
                }
                if (i == 0 || a[i - 1][j] == 0) {
                    upperHit = true;
                    hits++;
                }
                if (j == a[i].length - 1 || a[i][j + 1] == 0) {
                    rightHit = true;
                    hits++;
                }
                if (i == a.length - 1 || a[i + 1][j] == 0) {
                    lowerHit = true;
                    hits++;
                }

                if (hits == 4) wholes++;
                else if (hits == 3) threeHitCorners++;
                else if (hits == 2 && !(rightHit && leftHit) && !(upperHit && lowerHit)) twoHitCorners++;
            }

            if (j == a[i].length - 1) {
                i++;
                j = -1;
            }
        }

        return twoHitCorners / 4 + threeHitCorners / 2 + wholes;
    }
}
