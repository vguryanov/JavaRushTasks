package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by User2 on 22.02.2018.
 */
class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currency = ConsoleHelper.askCurrencyCode();
        String[] notes = ConsoleHelper.getValidTwoDigits(currency);
        try {
            int den = Integer.parseInt(notes[0]);
            int count = Integer.parseInt(notes[1]);

            CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
            manipulator.addAmount(den, count);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), den * count, currency));
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}

