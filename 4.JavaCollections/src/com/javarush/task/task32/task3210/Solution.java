package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile file = new RandomAccessFile(args[0], "rw");
            int position = Integer.parseInt(args[1]);
            String text = args[2];

            file.seek(position);
            byte[] filetext = new byte[text.length()];
            file.read(filetext,0,filetext.length);

            file.seek(file.length());
            if (convertByteToString(filetext).equals(text)) {
                file.write("true".getBytes());
            } else file.write("false".getBytes());

        } catch (IOException e) {
        }
    }

    public static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
