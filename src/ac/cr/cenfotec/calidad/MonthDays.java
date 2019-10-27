package ac.cr.cenfotec.calidad;

enum MonthDays {
    JANUARY(0, 31),
    FEBRUARY(31, 28),
    MARCH(59, 31),
    APRIL(90, 30),
    MAY(120, 31),
    JUNE(151, 30),
    JULY(181, 31),
    AUGUST(212, 30),
    SEPTEMBER(243, 31),
    OCTOBER(273,30),
    NOVEMBER(304,31),
    DECEMBER(335, 30);

    private int daysAccumulation;
    private int monthDays;

    public int getDays() {
        return this.daysAccumulation;
    }
    public int getMonthDays() {
        return this.monthDays;
    }

    MonthDays(int daysAccumulation, int monthDays) {
        this.daysAccumulation = daysAccumulation;
        this.monthDays = monthDays;
    }
}
