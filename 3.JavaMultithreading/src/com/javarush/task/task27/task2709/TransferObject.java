package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public int get() {
        while (!isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
        }

        System.out.println("Got: " + value);
        isValuePresent = false;
        notify();
        return value;
    }

    public void put(int value) {
        while (isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
        }

        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notify();
    }
}
