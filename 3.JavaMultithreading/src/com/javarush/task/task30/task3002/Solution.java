package com.javarush.task.task30.task3002;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int radix = 10;

        if (s.startsWith("0")) {
            if (s.charAt(1)=='x') {
                s = s.replace("0x","");
                radix = 16;
            } else if (s.charAt(1)=='b') {
                s = s.replace("0b","");
                radix = 2;
            } else radix = 8;
        }

        return s = String.valueOf(Integer.parseInt(s, radix));
    }
}
