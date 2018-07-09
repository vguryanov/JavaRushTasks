package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            for (String s : ((PrepareMyTest) c.getAnnotation(PrepareMyTest.class)).fullyQualifiedNames()) {
                System.out.println(s);
            }
            return true;
        } else return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            for (Class clazz : ((PrepareMyTest) c.getAnnotation(PrepareMyTest.class)).value()) {
                System.out.println(clazz.getSimpleName());
            }
            return true;
        } else return false;
    }
}
