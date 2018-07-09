package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * Created by User2 on 22.02.2018.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
