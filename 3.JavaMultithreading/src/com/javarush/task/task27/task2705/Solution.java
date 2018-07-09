package com.javarush.task.task27.task2705;

/* 
Второй вариант deadlock
*/
public class Solution extends Thread{
    private final Object lock = new Object();

    public synchronized void run() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock){
            synchronized (this){
                doSomething();
            }
        }
    }

    private void doSomething() {
        System.out.println("wadda?..");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}