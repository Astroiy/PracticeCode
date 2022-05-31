package ConstructorAndInitialization;

import java.util.Date;

public class DateClass {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());
        Date e = (Date) d.clone();
        System.out.println(e);
    }
}
