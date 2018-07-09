package com.javarush.task.task25.task2506;

/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        Thread.sleep(500);
        target.start();  //NEW
        Thread.sleep(100); //RUNNABLE
        target.join(100);
        Thread.sleep(400);
        target.interrupt(); //TERMINATED
        Thread.sleep(500);
    }
}

class LoggingStateThread extends Thread {
    Thread target;

    public LoggingStateThread(Thread thread) {
        super();
        this.target = thread;
    }

    @Override
    public void run() {
        Thread.State lastState = null;
        Thread.State lastState2 = null;

        while (lastState != State.TERMINATED) {

            lastState = target.getState();

            if (lastState != lastState2) {
                System.out.println(lastState);
                lastState2 = lastState;
            }
        }
    }
}