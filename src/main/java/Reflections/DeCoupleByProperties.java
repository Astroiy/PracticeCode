package Reflections;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class DeCoupleByProperties {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties pro = new Properties();
        FileReader in = new FileReader("src\\Reflections\\Patterns.Singleton.Student.txt");
        pro.load(in);
        in.close();

        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        Class<?> cl = Class.forName(className);
        Object obj = cl.getConstructor().newInstance();
        Method declaredMethod = cl.getDeclaredMethod(methodName);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(obj);
        System.out.println(invoke);
    }
}
