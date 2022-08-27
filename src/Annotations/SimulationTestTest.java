package Annotations;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SimulationTestTest {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> cl = Class.forName("Annotations.Student");
        Method[] methods = cl.getMethods();
        //Arrays.sort(methods, Comparator.comparing(Method::getName));

        Arrays.sort(methods,(x,y)->{
           if(x.isAnnotationPresent(MyTest.class) && y.isAnnotationPresent(MyTest.class)){
               MyTest a1 = x.getAnnotation(MyTest.class);
               MyTest a2 = y.getAnnotation(MyTest.class);
               return a1.index()-a2.index();
           }
           return 0;
        });
        AccessibleObject.setAccessible(methods,true);

        Arrays.stream(methods)
                .filter(x->x.isAnnotationPresent(MyTest.class))
                .forEach(x-> {
                    try {
                        x.invoke(new Student());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });


        /*for (Method method : methods) {
            if(method.isAnnotationPresent(MyTest.class))
                method.invoke(new Patterns.Singleton.Student());
        }*/
    }
}
