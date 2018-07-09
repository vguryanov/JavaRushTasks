package com.javarush.task.task35.task3501;

public class GenericStatic {
    public static <T, U extends T> T someStaticMethod(U genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }
}
