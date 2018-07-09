package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by User2 on 20.02.2018.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = null;

        try {
            result = bis.readLine();
        } catch (IOException e) {
        }

        if (result.equalsIgnoreCase("EXIT")) {
            ConsoleHelper.writeMessage(res.getString("the.end"));
            throw new InterruptOperationException();
        }

        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String input = "";

        while (input.length() != 3) {
            writeMessage(res.getString("choose.currency.code"));
            input = readString();
            if (input.length() != 3) writeMessage(res.getString("invalid.data"));
        }

        return input.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] result = new String[2];
        String input = "";

        while (!input.matches("\\d+\\s\\d+")) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            input = readString();
        }

        return new String[]{input.split(" ")[0], input.split(" ")[1]};
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation result = null;
        while (result == null) {
            writeMessage(res.getString("choose.operation"));
            try {
                result = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        switch (result) {
            case DEPOSIT:
                writeMessage(res.getString("operation.DEPOSIT"));
                break;
            case INFO:
                writeMessage(res.getString("operation.INFO"));
                break;
            case WITHDRAW:
                writeMessage(res.getString("operation.WITHDRAW"));
                break;
            case EXIT:
                writeMessage(res.getString("operation.EXIT"));
                break;
        }

        return result;
    }

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
