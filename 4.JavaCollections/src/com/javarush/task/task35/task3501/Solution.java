package com.javarush.task.task35.task3501;

import java.util.ArrayList;
import java.util.List;

/*
Вызов статического метода
*/
public class Solution {
    public static void main(String[] args) {
        Number number = GenericStatic.someStaticMethod(new Integer(3));
    }
}