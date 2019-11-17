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
        assertFalse(Calendar.isLeapYear(1581));
        assertTrue(Calendar.isLeapYear(2020));
        assertTrue(Calendar.isLeapYear(2000));
        assertFalse(Calendar.isLeapYear(2100));
        assertFalse(Calendar.isLeapYear(2900));
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
        assertTrue(Calendar.isValidDate(1, 29, 2005));
        assertTrue(Calendar.isValidDate(11, 2, 2005));
        assertTrue(Calendar.isValidDate(12, 29, 2005));
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
        assertArrayEquals(new int[]{3, 1, 2019}, Calendar.nextDay(2, 28, 2019));
        assertArrayEquals(new int[]{2, 29, 2020}, Calendar.nextDay(2, 28, 2020));
    }

    @Test
    void getDaysBetween(){
        assertEquals(1, Calendar.daysBetween(2019,11,16,2019, 11 ,17));
        assertEquals(2, Calendar.daysBetween(2019,11,18,2019, 11 ,16));
    }

    @Test
    void getFutureDate() {
        int[] sameMonthDate = Calendar.futureDate(new int[] {2, 12, 2019}, 3);
        int[] differentMonthDate = Calendar.futureDate(new int[] {5, 25, 2019}, 10);
        int[] differentYearDate = Calendar.futureDate(new int[] {12, 20, 2019}, 20);
        assertArrayEquals(new int[] {2, 15, 2019}, sameMonthDate);
        assertArrayEquals(new int[] {6, 4, 2019}, differentMonthDate);
        assertArrayEquals(new int[] {1, 9, 2020}, differentYearDate);
    }
}