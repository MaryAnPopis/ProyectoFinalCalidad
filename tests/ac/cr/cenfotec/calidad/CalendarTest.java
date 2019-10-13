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
}