package Annotations;

public class Student {
    private String name;
    @MyTest(index=1)
    public void show1(){
        System.out.println("show1()...");
    }

    @MyTest(index=0)
    public void show2(){
        System.out.println("show2()...");
    }
    public Student(){}

    public void show3(){
        System.out.println("show3()...");
    }
}
