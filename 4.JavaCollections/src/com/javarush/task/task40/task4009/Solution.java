package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(weekDayOfBirthday("11.12.2015", "2016"));
    }

    public static String weekDayOfBirthday(String birthday, String year) {
        LocalDate date = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ITALIAN));
        date = date.with(Year.parse(year));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN);

        return formatter.format(date.getDayOfWeek());
    }
}
