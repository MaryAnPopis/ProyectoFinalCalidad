package ac.cr.cenfotec.calidad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {

    @Test
    void getDayOfWeek() {
        int dayOfTheWeek = Calendar.getDayOfWeek(2019, 10, 12);
        assertEquals(6, dayOfTheWeek);
    }

    @Test
    void getDayOfWeekInLeapYear() {
        int dayOfTheWeek = Calendar.getDayOfWeek(2020, 2, 29);
        assertEquals(6, dayOfTheWeek);
    }


    @Test
    void dayOfYear() {
        assertEquals(1, Calendar.dayOfYear(1, 1, 2019));
        assertEquals(0, Calendar.dayOfYear(1, 32, 2016));
        assertEquals(60, Calendar.dayOfYear(2, 29, 2020));
        assertEquals(0, Calendar.dayOfYear(2, 29, 2021));
        assertEquals(0, Calendar.dayOfYear(5, 0, 2011));
        assertEquals(0, Calendar.dayOfYear(13, 12, 2010));
        assertEquals(0, Calendar.dayOfYear(0, 12, 2010));
        assertEquals(0, Calendar.dayOfYear(1, 12, 1581));
        assertEquals(0, Calendar.dayOfYear(1, 12, 2900));
    }

    @Test
    void isLeapYear() {
        boolean isLeapYear = Calendar.isLeapYear(2020);
        assertTrue(isLeapYear);
        assertTrue(!Calendar.isLeapYear(1581));
        assertTrue(!Calendar.isLeapYear(2900));
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
        try {
            int[] dateArray = Calendar.getDateFromTuple("(2019,5,6)");
            assertTrue(dateArray.length == 3);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getInvalidFormatFromTuple() {
        try {
            int[] dateArray = Calendar.getDateFromTuple("2019,5,6");
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void nextDate() {
        assertArrayEquals(new int[]{1, 2, 2019}, Calendar.nextDay(1, 1, 2019));
        assertArrayEquals(new int[]{2, 1, 2019}, Calendar.nextDay(1, 31, 2019));
        assertArrayEquals(new int[]{1, 1, 2020}, Calendar.nextDay(12, 31, 2019));
        assertArrayEquals(new int[]{2, 29, 2019}, Calendar.nextDay(2, 28, 2019));
    }
}