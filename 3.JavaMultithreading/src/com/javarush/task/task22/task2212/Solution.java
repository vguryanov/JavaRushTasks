package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null||telNumber.equals("")) return false;
        Pattern pattern1 = Pattern.compile("\\+\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Pattern pattern2 = Pattern.compile("\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Matcher matcher1 = pattern1.matcher(telNumber);
        Matcher matcher2 = pattern2.matcher(telNumber);
        if (matcher1.matches()){

            if (telNumber.replaceAll("\\D","").length()==12){

                return true;

            }
            return false;
        }
        if (matcher2.matches()) {

            if (telNumber.replaceAll("^\\D", "").length() == 10) {

                return true;

            }
            return false;
        }



        return false;
    }

    public static void main(String[] args) {

    }
}
