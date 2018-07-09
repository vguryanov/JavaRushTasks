package com.javarush.task.task32.task3203;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream systemOut = System.out;

        System.setOut(printStream);
        System.out.println("wtf bitch");

        System.setOut(systemOut);
        System.out.println(byteArrayOutputStream.toString());
    }
}