package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        ArrayList<Throwable> list = new ArrayList<>();

        t.interrupt();

        list.add(e);
        Throwable throwable = e.getCause();
        while (throwable != null) {
            list.add(throwable);
            throwable = throwable.getCause();
        }

        for (int i = list.size()-1; i >= 0; i--) System.out.println(list.get(i));
    }


    public static void main(String[] args) {
        myThread myThread = new myThread();
        Thread.UncaughtExceptionHandler handler = new Solution();
        myThread.setUncaughtExceptionHandler(handler);
        try {
            myThread.run2();
        } catch (Exception e) {
            handler.uncaughtException(Thread.currentThread(), e);
        }
    }
}

class myThread extends Thread {

    public void run2() throws Exception {
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
    }
}