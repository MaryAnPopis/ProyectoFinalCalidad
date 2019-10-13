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
    void getDateFromTuple() {
        try{
            int[] dateArray = Calendar.getDateFromTuple("(2019,5,6)");
            assertTrue(dateArray.length == 3);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getInvalidFormatFromTuple() {
        try{
            int[] dateArray = Calendar.getDateFromTuple("2019,5,6");
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}