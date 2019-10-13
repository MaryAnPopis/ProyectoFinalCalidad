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


    public static int dayOfYear(int month, int dayOfMonth) {
        MonthDays[] monthDay = MonthDays.values();
        dayOfMonth  += monthDay[month-1].getDays();
        return dayOfMonth;
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

    public static boolean isValidDate(int month, int dayOfMonth, int year) {
        return month >= 1 && month <= 12 && dayOfMonth > 0 && dayOfMonth <= daysInMonth(month, year) && year >= 1582;
    }
}
