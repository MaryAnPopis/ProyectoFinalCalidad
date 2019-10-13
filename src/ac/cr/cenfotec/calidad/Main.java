package ac.cr.cenfotec.calidad;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ac.cr.cenfotec.calidad.Calendar.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isExitMenu = false;
        do {
            try {
                System.out.println("Ingrese una opción:\n1. Revisar año bisiesto\n2. Buscar día siguiente\n3. Buscar día de la semana\n4. Salir");
                int userOption = Integer.parseInt(br.readLine());

                switch (userOption) {
                    case 1:
                        checkLeapYear(br);
                        break;
                    case 2:
                        getNextDay(br);
                        break;
                    case 3:
                        getWeekDay(br);
                        break;
                    case 4:
                        isExitMenu = true;
                        break;
                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Por favor seleccione una opción correcta");
            }
        } while (!isExitMenu);
    }

    static void checkLeapYear(BufferedReader br) {
        try {
            System.out.println("Ingrese un año que desea revisar (Debe ser mayor a 1582)");
            int yearInput = Integer.parseInt(br.readLine());
            if (yearInput < 1582) throw new Exception();
            if (Calendar.isLeapYear(yearInput)) System.out.println("Es bisiesto");
            else System.out.println("No es bisiesto");
        } catch (Exception e) {
            System.out.println("El año ingresado no es valido");
        }
    }

    static void getNextDay(BufferedReader br) {
        try {
            System.out.println("Ingrese una fecha inicial en formato \"(año,mes,día)\"(El año debe ser mayor a 1582)");
            String dateInput = br.readLine();
            int[] date = Calendar.getDateFromTuple(dateInput);
            if (!Calendar.isValidDate(date[1], date[2], date[0])) throw new Exception();

            int[] nextDay = Calendar.nextDay(date[1], date[2], date[0]);

            System.out.println("El siguiente dia es: " + nextDay[2] +", " + nextDay[0] + ", " + nextDay[1] + ".");

        } catch (Exception e) {
            System.out.println("La fecha ingresada no es valida");
        }
    }

    static void getWeekDay(BufferedReader br) {
        try {
            System.out.println("Ingrese una fecha en formato \"(año,mes,día)\"(El año debe ser mayor a 1582)");
            String dateInput = br.readLine();
            int[] date = Calendar.getDateFromTuple(dateInput);
            if (!Calendar.isValidDate(date[1], date[2], date[0])) throw new Exception();
            System.out.println("Día de la semana: " + getDayOfWeek(date[0], date[1], date[2]));
        } catch (Exception e) {
            System.out.println("La fecha ingresada no es valida");
        }
    }


}