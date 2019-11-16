package ac.cr.cenfotec.calidad;

enum MonthDays {
    JANUARY(0, 31),
    FEBRUARY(31, 28),
    MARCH(59, 31),
    APRIL(90, 30),
    MAY(120, 31),
    JUNE(151, 30),
    JULY(181, 31),
    AUGUST(212, 31),
    SEPTEMBER(243, 30),
    OCTOBER(273,31),
    NOVEMBER(304,30),
    DECEMBER(335, 31);

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
