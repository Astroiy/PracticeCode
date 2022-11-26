package Reflections;

import java.lang.reflect.*;
import java.time.LocalDate;
import java.util.Arrays;

public class ArrayTypeFields {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Worker> cl = Worker.class;
        Constructor<Worker> con = cl.getDeclaredConstructor(String[].class, String.class, int[].class);
        con.setAccessible(true);
        Worker worker = con.newInstance("I Love My Babe".split(" "), "Tiny", new int[]{17, 28, 37, 82, 18, 27});

        Field messages = cl.getDeclaredField("messages");
        Field name = cl.getDeclaredField("name");
        Field wagePerDay = cl.getDeclaredField("wagePerDay");
        Field[] fields = {messages, name, wagePerDay};
        AccessibleObject.setAccessible(fields,true);

        System.out.println(Arrays.toString((String[])messages.get(worker)));
        System.out.println(name.get(worker));
        System.out.println(Arrays.toString((int[]) wagePerDay.get(worker)));

        Object a1 = messages.get(worker);
        Object a2 = wagePerDay.get(worker);
        System.out.println(Array.get(a1,1));
        System.out.println(Array.get(a2,1));

        LocalDate[] dates = new LocalDate[]{LocalDate.now(),LocalDate.of(2020,1,29)};
        System.out.println(Array.get(dates,0));

        int anInt = Array.getInt(a2, 2);
        Array.set(dates,1,LocalDate.now());
        System.out.println(Arrays.toString(dates));

        Object o = Array.newInstance(int.class, 5);
        System.out.println("类型为"+o.getClass().getSimpleName());

        Method showMessages = cl.getDeclaredMethod("showMessage");
        showMessages.invoke(null);
    }
}

class Worker{
    private String[] messages;
    private String name;
    private int[] wagePerDay;

    public Worker(){}

    private Worker(String[] messages,String name,int[] wagePerDay){
        this.messages=messages;
        this.name = name;
        this.wagePerDay = wagePerDay;
    }

    public static void showMessage(){
        System.out.println("Invoke static method!");
    }
}
