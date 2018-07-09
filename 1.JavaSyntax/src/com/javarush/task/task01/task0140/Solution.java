package com.javarush.task.task01.task0140;

import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) {
        int a;
        Scanner scanner = new Scanner(System.in);
        System.out.println((int) Math.pow(a = scanner.nextInt(), 2));
    }
}