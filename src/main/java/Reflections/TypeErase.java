package Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TypeErase {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> integers = new ArrayList<>(List.of(11, 22));
        Class<? extends ArrayList> cl = integers.getClass();
        Method add = cl.getDeclaredMethod("add", Object.class);
        add.invoke(integers,"String");
        for (Object obj : integers) {
            System.out.println(obj+"该元素类型为: "+obj.getClass().getSimpleName());
        }

    }
}
