package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            String inputString = "31.12.2020";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = dateFormat.parse(inputString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, 45);
            Date increasedDate = calendar.getTime();
            System.out.println("Дата, увеличенная на 45 дней: " + dateFormat.format(increasedDate));
            calendar.set(Calendar.DAY_OF_YEAR, 1);
            Date startOfYearDate = calendar.getTime();
            System.out.println("Дата, сдвинутая на начало года: " + dateFormat.format(startOfYearDate));
            int workDaysToAdd = 10;
            int addedWorkDays = 0;
            while (addedWorkDays < workDaysToAdd) {
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    addedWorkDays++;
                }
            }
            Date increasedWorkDaysDate = calendar.getTime();
            System.out.println("Дата, увеличенная на 10 рабочих дней: " + dateFormat.format(increasedWorkDaysDate));
            String secondInputString = "01.01.2021";
            Date secondDate = dateFormat.parse(secondInputString);
            int workDays = 0;
            Calendar workDaysCounter = Calendar.getInstance();
            workDaysCounter.setTime(date);
            while (workDaysCounter.getTime().before(secondDate)) {
                int dayOfWeek = workDaysCounter.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    workDays++;
                }
                workDaysCounter.add(Calendar.DAY_OF_YEAR, 1);
            }
            System.out.println("Количество рабочих дней между первой и второй датами: " + workDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}