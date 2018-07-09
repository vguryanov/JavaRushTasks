package com.javarush.task.task37.task3711;

/**
 * Created by User2 on 22.09.2017.
 */
public class Computer {
    CPU cpu;
    Memory memory;
    HardDrive hardDrive;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void run() {
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
