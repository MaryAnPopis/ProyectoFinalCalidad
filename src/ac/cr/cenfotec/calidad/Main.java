package ac.cr.cenfotec.calidad;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ac.cr.cenfotec.calidad.Calendar.*;


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


}