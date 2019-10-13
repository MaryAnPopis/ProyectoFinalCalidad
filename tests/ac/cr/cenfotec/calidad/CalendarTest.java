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
    }

    @Test
    void isLeapYear() {
    }

    @Test
    void daysInMonth() {
    }

    @Test
    void isValidDate() {
    }
}