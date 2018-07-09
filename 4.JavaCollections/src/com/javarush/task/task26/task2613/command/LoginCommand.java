package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by User2 on 25.02.2018.
 */
public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        boolean verificated = false;

        while (!verificated) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));

            String numberInput = ConsoleHelper.readString();
            String pinInput = ConsoleHelper.readString();

            if (numberInput.matches("\\d{12}") && pinInput.matches("\\d{4}")) {
                if (validCreditCards.containsKey(numberInput) && pinInput.equals(validCreditCards.getString(numberInput))) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), numberInput));
                    verificated = true;
                }
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), numberInput));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}
