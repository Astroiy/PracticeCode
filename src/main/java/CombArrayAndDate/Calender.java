package CombArrayAndDate;

import java.time.LocalDate;
import java.util.Date;
import java.time.DayOfWeek;


public class Calender {
    public static void main(String[] args){
        int year = LocalDate.now().getYear();
        LocalDate ld = LocalDate.of(1999,12,31);
        LocalDate aTdslater = ld.plusDays(1000);
        DayOfWeek dow = ld.getDayOfWeek();

        System.out.println(new Date());

        System.out.println(year);
        System.out.println(LocalDate.now());
        System.out.println(ld);
        System.out.println(aTdslater);
        System.out.println(dow);
        System.out.println(dow.getValue());
        System.out.println(dow.getValue()==5);

        NewCalender.showCalender();
    }
}
