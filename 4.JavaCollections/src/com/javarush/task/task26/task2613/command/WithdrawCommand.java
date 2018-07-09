package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by User2 on 22.02.2018.
 */
class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());

        int amount = 0;
        while (amount < 1) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));

            try {
                amount = Integer.parseInt(ConsoleHelper.readString());
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                amount = 0;
            }
            if (amount < 1) ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));;
            if (!manipulator.isAmountAvailable(amount)){
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                amount = 0;            }

            Map<Integer, Integer> withdraw = null;
            try {
                withdraw = manipulator.withdrawAmount(amount);

                List<Integer> denominationsList = new ArrayList<>(withdraw.keySet());
                Collections.sort(denominationsList);
                Collections.reverse(denominationsList);

                for (Integer i : denominationsList) ConsoleHelper.writeMessage("\t" + i + " - " + withdraw.get(i));

                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, manipulator.getCurrencyCode()));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                amount = 0;
            }
        }
    }
}
