package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("amigo.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        String s = "";
        StringWriter result = new StringWriter();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            while (bufferedReader.ready()) s += bufferedReader.readLine();
            result.write(s);
            return result;
        } catch (Exception e) {
            result.write("exception, bitch");
        } finally {
            return result;
        }
    }
}