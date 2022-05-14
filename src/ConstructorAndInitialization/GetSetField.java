package ConstructorAndInitialization;

import java.lang.reflect.Field;

public class GetSetField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        var harry = new Employee("Harry Potter",2000,2021,2,25);
        Class cl = harry.getClass();
        Field f = cl.getSuperclass().getDeclaredField("name");
        f.setAccessible(false);
        Object obj = f.get(harry);

    }
}
