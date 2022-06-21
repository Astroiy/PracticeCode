package LearnMaps;


import java.util.*;

public class LearnEnumSet {
    public static void main(String[] args) {
        EnumSet<Weekday> weekdaysAll = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> weekends = EnumSet.range(Weekday.SATURDAY, Weekday.SUNDAY);
        EnumSet<Weekday> none = EnumSet.noneOf(Weekday.class);

        EnumSet<Weekday> varargs = EnumSet.of(Weekday.FRIDAY, Weekday.MONDAY);

        System.out.println(weekdaysAll);
        System.out.println(weekends);
        System.out.println(none);
        System.out.println(varargs);

        varargs.add(Weekday.SATURDAY);
        System.out.println(varargs);

    }
}

enum Weekday{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
}
