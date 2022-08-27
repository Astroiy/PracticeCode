package Patterns.Singleton;

import java.util.Objects;

public class Student {
    private Student(){}

    private static Student stu ;

    public static synchronized Student getInstance(){

       /* if(stu==null)
            return stu=new Patterns.Singleton.Student();
        else
            return stu;*/

        return Objects.requireNonNullElseGet(stu,()->stu=new Student());
    }
}

class TestStudent{
    public static void main(String[] args) {
        Student instance1 = Student.getInstance();
        Student instance2 = Student.getInstance();
        Student instance3 = Student.getInstance();

        System.out.println(instance1==instance2);
        System.out.println(instance2==instance3);
    }
}
