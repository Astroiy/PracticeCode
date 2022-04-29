package CombArrayAndDate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class NewCalender {
    public static void showCalender(){
        LocalDate date = LocalDate.now();              //获取当时年月日
        int month = date.getMonthValue();              //保存月份
        int monthday = date.lengthOfMonth();         //保存当月日期数，后面可以和for循环配合输出日历
        int today = date.getDayOfMonth();              //保存日期，用于判断是否在打印处加*号
        date = date.minusDays(today-1);  //将日期重置至当月一日
        DayOfWeek weekday = date.getDayOfWeek();       //保存当月一日的星期序数，用于判断何时开始打印
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        for(int i=0;i<value-1;i++)
            System.out.printf("    ");

        //for(int i =1;i<=monthday;i++){
        while(date.getMonthValue()==month){             //判断date是否还是当月日期
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth()==today)
                System.out.print("*");
            else
                System.out.print(" ");
            if(date.getDayOfWeek().getValue()==7)
                System.out.println();
            date = date.plusDays(1);
        }


    }
    public static class Test{
        public static void main(String[] args){
            showCalender();
        }
    }
}
