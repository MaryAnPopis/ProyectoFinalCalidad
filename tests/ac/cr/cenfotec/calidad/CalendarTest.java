package ac.cr.cenfotec.calidad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {

    @Test
    void getDayOfWeek() {
        int dayOfTheWeek = Calendar.getDayOfWeek(2019,10,12);
        assertEquals(6, dayOfTheWeek);
    }

    @Test
    void getDayOfWeekInLeapYear() {
        int dayOfTheWeek = Calendar.getDayOfWeek(2020,2,29);
        assertEquals(6, dayOfTheWeek);
    }


    @Test
    void dayOfYear() {
        int day = Calendar.dayOfYear(1, 1);
        assertEquals(1, day);
    }

    @Test
    void isLeapYear() {
        boolean isLeapYear = Calendar.isLeapYear(2020);
        assertTrue(isLeapYear);
    }

    @Test
    void isNotLeapYear() {
        boolean isLeapYear = Calendar.isLeapYear(2019);
        assertFalse(isLeapYear);
    }


    @Test
    void daysInMonth() {
    }

    @Test
    void isNotValidDate() {
        boolean isNotValid = Calendar.isValidDate(15, 29, 2020);
        assertFalse(isNotValid);
    }

    @Test
    void isValidDate() {
        boolean isValidDate = Calendar.isValidDate(1, 29, 2005);
        assertTrue(isValidDate);
    }

    @Test
    void nextDay() {
        int[] nextDay = new int[] {1, 2, 2019};
        int[] nextMonth = new int[] {2, 1, 2019};
        int[] nextYear = new int[] {1, 1, 2020};
        assertArrayEquals(nextDay, Calendar.nextDay(1,1, 2019));
        assertArrayEquals(nextMonth, Calendar.nextDay(1,31, 2019));
        assertArrayEquals(nextYear, Calendar.nextDay(12,31, 2019));
    }
}