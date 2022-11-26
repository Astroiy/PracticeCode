package Reflections;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GetVariousConstructors {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Student> cl = Student.class;
        Constructor<?>[] cons = cl.getDeclaredConstructors();

        AccessibleObject.setAccessible(cons,true);
        /*System.out.println(Arrays.toString(cons));
        cons[0].newInstance("Tiny",18,20);
        cons[1].newInstance("Amy",18);
        cons[2].newInstance("Someone");
        cons[3].newInstance();*/
        for (int i = 0; i < cons.length; i++) {
            Class<?>[] parameterTypes = cons[i].getParameterTypes();
            int l = parameterTypes.length;
        }
    }
}
class Student{
    private String name;
    private Integer age;
    private Integer id;
    public Student(){
        System.out.println("调用了public无参构造方法");
    }

    Student(String name){
        System.out.println("调用了默认单名字参数方法");
        this.name = name;
    }

    protected Student(String name,Integer age){
        System.out.println("调用了protected双参构造方法");
        this.name = name;
        this.age = age;
    }

    private Student(String name,Integer age,Integer id){
        System.out.println("调用了private三参构造方法");
        this.name = name;
        this.age= age;
        this.id = id;
    }
}
