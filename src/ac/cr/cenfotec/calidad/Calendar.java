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


    public static int dayOfYear(int month, int day) {
        MonthDays[] monthDay = MonthDays.values();
        day  += monthDay[month-1].getDays();
        return day;
    }

    public static boolean isLeapYear(int year) {
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
        return MonthDays.values()[month - 1].getDays() + daysInMonth(month, year) == dayOfYear(month, day);
    }
}
