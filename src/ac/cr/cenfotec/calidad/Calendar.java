package ac.cr.cenfotec.calidad;

public class Calendar {

    // tomohiko sakamoto algorithm
    public static int getDayOfWeek(int year, int month, int day){
        // array with leading number of days values
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };

        if (month < 3)
            year -= 1;

        return (year + year / 4 - year / 100 + year / 400 + t[month - 1] + day) % 7;
    }


    public static int dayOfYear(int month, int day, int year) {

        MonthDays[] monthDay = MonthDays.values();

        if (day <= 0
                || (month <= 0 || month > 12)
                || (year < 1582 || year >= 2900)
                || (isLeapYear(year) && month >= 2 ? monthDay[month-1].getMonthDays() + 1 : monthDay[month-1].getMonthDays()) < day) {
            return 0;
        }
        day  += monthDay[month-1].getDays();
        return day;
    }

    public static boolean isLeapYear(int year) {

        if (year < 1582 || year >= 2900) {
            return false;
        }

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

    public static int daysInMonth(int month, int year) {
        switch (month) {
            case 2 :
                return isLeapYear(year) ? 29 : 28;
            case 4 : case 6 : case 9 : case 11:
                return 30;
            default :
                return 31;
        }
    }

    public static boolean isValidDate(int month, int day, int year) {
        return month >= 1 && month <= 12 && day > 0 && day <= daysInMonth(month, year) && year >= 1582;
    }

    public static int[] nextDay(int month, int day, int year) {
        if (isLastDayOfMonth(month, day, year)) {
            return month == 12 ? new int[] {1, 1, year += 1} : new int[] {month += 1, 1, year};
        } else {
            return new int[] {month, day += 1 , year};
        }
    }

    private static boolean isLastDayOfMonth(int month, int day, int year) {
        return MonthDays.values()[month - 1].getDays() + daysInMonth(month, year) == dayOfYear(month, day, year);
    }

    static int[] getDateFromTuple(String dateTuple) throws Exception {
        dateTuple = dateTuple.trim();
        if (dateTuple.charAt(0) == '(' && dateTuple.charAt(dateTuple.length() -1) == ')') {
            dateTuple = dateTuple.substring(1, dateTuple.length() -1);

            String[] separatedDate = dateTuple.split(",");

            if (separatedDate.length == 3) {
                return new int[] {Integer.parseInt(separatedDate[0]), Integer.parseInt(separatedDate[1]), Integer.parseInt(separatedDate[2])};
            }
        }
        throw new Exception();
    }

    public static int daysBetween(int year1, int month1, int day1, int year2, int month2, int day2){
        return Math.abs(dayOfYear(month1, day1, year1) - dayOfYear(month2, day2, year2));
    }

    public static int[] futureDate(int[] initialDate, int nextDays, boolean isRecursion) {
        if ((isValidDate(initialDate[0], initialDate[1], initialDate[2]) || isRecursion) && nextDays >= 0)  {
            int daysInDatesMonth = daysInMonth(initialDate[0], initialDate[2]);
            if (daysInDatesMonth <= nextDays + initialDate[1]) {
                int[] newDateAux = initialDate[0] == 12 ? new int[] {1, 0, initialDate[2]+1} : new int[] {initialDate[0]+1, 0, initialDate[2]} ;

                nextDays -= (daysInDatesMonth - initialDate[1]);
                 return futureDate(newDateAux, nextDays, true);
            } else {
                initialDate[1] += nextDays;
            }
            return initialDate;
        }
        return null;
    }

    public static int[] futureDate(int[] initialDate, int nextDays) {
        return futureDate(initialDate, nextDays, false);
    }

    public static int[] passedDate(int[] initialDate, int days) {
        if ((isValidDate(initialDate[0], initialDate[1], initialDate[2])) && days >= 0)  {
            int daysInDatesMonth = daysInMonth(initialDate[0], initialDate[2]);
            if (0 >= initialDate[1] - days) {
                int[] newDateAux = initialDate[0] == 1 ? new int[] {12, 0, initialDate[2]-1} : new int[] {initialDate[0]-1, 0, initialDate[2]} ;

                if(initialDate[0] == 1) {
                    newDateAux = new int[] {12, 0, initialDate[2]-1};
                    int diff = days - initialDate[1];
                    newDateAux[1] = daysInDatesMonth - diff;
                } else {
                    days = (daysInDatesMonth - initialDate[1]);
                    newDateAux[1] = days;
                }

                return newDateAux;
            } else {
                initialDate[1] -= days;
            }
            return initialDate;
        }
        return null;
    }

}
