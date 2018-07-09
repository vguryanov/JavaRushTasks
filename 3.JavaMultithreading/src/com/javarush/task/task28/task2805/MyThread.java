package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by User2 on 13.04.2017.
 */
public class MyThread extends Thread {
    private static AtomicInteger count = new AtomicInteger(0);

    private void getCount(ThreadGroup group) {
        this.setPriority(count.incrementAndGet());
        if (group != null && this.getPriority() > group.getMaxPriority()) this.setPriority(group.getMaxPriority());
        if (count.intValue() == 10) count.set(0);
    }

    public MyThread() {
        super();
        getCount(null);
    }

    public MyThread(Runnable target) {
        super(target);
        getCount(null);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        getCount(group);
    }

    public MyThread(String name) {
        super(name);
        getCount(null);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        getCount(group);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        getCount(null);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        getCount(group);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        getCount(group);
    }
}
