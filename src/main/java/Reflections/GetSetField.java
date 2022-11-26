package Reflections;

import ConstructorAndInitialization.Employee;

import java.lang.reflect.*;

public class GetSetField {
    public static class OldVersion {
        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
            var harry = new Employee("Harry Potter", 2000, 2021, 2, 25);
            Class<? extends Employee> cl = harry.getClass();
            Field f = cl.getSuperclass().getDeclaredField("name");
            f.setAccessible(false);
            Object obj = f.get(harry);
        }
    }

    public static class NewVersion{
        public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

            Class<Student> cl = Student.class;

            Constructor<Student> constructor = cl.getDeclaredConstructor(String.class, Integer.class, Integer.class);
            constructor.setAccessible(true);
            Student tiny = constructor.newInstance("Tiny", 18, 20);

            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);

            Field name = fields[0];
            Field age = fields[1];
            Field id = fields[2];

            name.set(tiny,"Olivia");
            age.set(tiny,24);
            id.set(tiny,11);

            System.out.println(name.get(tiny));
            System.out.println(age.get(tiny));
            System.out.println(id.get(tiny));

        }
    }
}
