package ac.cr.cenfotec.calidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int month, day, year;

        do {
            System.out.println("Enter month as number");
            month =  Integer.parseInt(br.readLine());

            System.out.println("Enter day as number");
            day =  Integer.parseInt(br.readLine());

            System.out.println("Enter year as number");
            year =  Integer.parseInt(br.readLine());

            if(!isValidDate(month, day, year)) {
                System.out.println("Invalid Date, please enter a new one");
            }

        }while(!isValidDate(month, day, year));


        int dayOfYearResult = dayOfYear(month, day);
        System.out.println("The day is " + dayOfYearResult);

        boolean isLeap = isLeapYear(year);
        System.out.println(isLeap ? "The year is leap" : "The year is not leap");

    }


    static int dayOfYear(int month, int dayOfMonth) {
        MonthDays[] monthDay = MonthDays.values();
        dayOfMonth  += monthDay[month-1].getDays();
        return dayOfMonth;
    }

    static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    static int daysInMonth(int month, int year) {
        switch (month) {
            case 2 :
                return isLeapYear(year) ? 29 : 28;
            case 4 : case 6 : case 9 : case 11:
                return 30;
            default :
                return 31;
        }
    }

    static boolean isValidDate(int month, int dayOfMonth, int year) {
        return month >= 1 && month <= 12 && dayOfMonth > 0 && dayOfMonth <= daysInMonth(month, year) && year >= 1582;
    }
}