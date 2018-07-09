package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {

        for (Thread thread : threads) {
            switch (thread.getState()) {
                case NEW:
                    thread.start();
                    break;

                case BLOCKED:

                case TIMED_WAITING:

                case WAITING:
                    thread.notify();
                    break;

                case RUNNABLE:
                    thread.interrupt();
                    break;

                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
