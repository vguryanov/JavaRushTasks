package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        byte[] pass = new byte[8];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int[][] range = new int[3][2];
        range[0] = new int[]{26, 97};
        range[1] = new int[]{26, 65};
        range[2] = new int[]{10, 48};

        int upperCaseIndex = (int) (Math.random() * 8);
        int lowerCaseIndex = (int) (Math.random() * 8);
        int numIndex = (int) (Math.random() * 8);

        while (numIndex == upperCaseIndex) numIndex = (int) (Math.random() * 8);
        while (lowerCaseIndex == upperCaseIndex || lowerCaseIndex == numIndex)
            lowerCaseIndex = (int) (Math.random() * 8);

        for (int i = 0; i < pass.length; i++) {
            int pair;

            if (i == lowerCaseIndex) pair = 0;
            else if (i == upperCaseIndex) pair = 1;
            else if (i == numIndex) pair = 2;
            else pair = (int) (Math.random() * 3);

            pass[i] = (byte) (Math.random() * range[pair][0] + range[pair][1]);
        }

        try {
            outputStream.write(pass);
        } catch (IOException e) {

        }
        System.out.println(outputStream);

        return outputStream;
    }
}