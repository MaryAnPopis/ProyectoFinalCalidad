package ac.cr.cenfotec.calidad;

enum MonthDays {
    JANUARY(0),
    FEBRUARY(31),
    MARCH(59),
    APRIL(90),
    MAY(120),
    JUNE(151),
    JULY(181),
    AUGUST(212),
    SEPTEMBER(243),
    OCTOBER(273),
    NOVEMBER(304),
    DECEMBER(335);

    private int daysAccumulation;

    public int getDays() {
        return this.daysAccumulation;
    }

    MonthDays(int daysAccumulation) {
        this.daysAccumulation = daysAccumulation;
    }
}
