package com.javarush.task.task25.task2508;

public class TaskManipulator implements CustomThreadManipulator, Runnable {
    Thread thread;

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
            }
        }
    }
}
