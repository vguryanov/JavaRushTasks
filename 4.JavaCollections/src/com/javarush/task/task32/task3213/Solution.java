package com.javarush.task.task32.task3213;

import java.io.*;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter writer = new StringWriter();

        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            int i;

            while ((i = bufferedReader.read()) != -1) {
                if (i == 32) writer.write(i);
                else writer.write(i + key);
            }
        } catch (Exception e) {
            writer.write("exc");
        }

        return writer.toString();
    }

}
