package Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cl = Class.forName("ConstructorAndInitialization.Manager");
        Field[] f = cl.getDeclaredFields();
        for (Field field : f) {
            System.out.println(field);
            System.out.println(field.getName());
        }
        System.out.println();

        Method[] m = cl.getDeclaredMethods();
        for (Method method : m) {
            System.out.println(method.getName());
            Class[] para = method.getParameterTypes();
            Class rtype = method.getReturnType();
            System.out.println(rtype);
            System.out.println(Arrays.toString(para));
            System.out.println();

        }
        System.out.println();

        Constructor[] c = cl.getConstructors();
        for(Constructor constructor:c){
            System.out.println(constructor.getName());
            Class[] para = constructor.getParameterTypes();
            for(int i=0;i<para.length;i++){
                Field[] fields = para[i].getFields();
                for(int j=0;j<fields.length;j++){
                    System.out.print(fields[i].getType().getName()+" ");
                }
                System.out.println();
            }
        }

        System.out.println(cl.getModifiers());
        System.out.println(Modifier.toString(cl.getModifiers()));
        System.out.println(cl);
    }
}
