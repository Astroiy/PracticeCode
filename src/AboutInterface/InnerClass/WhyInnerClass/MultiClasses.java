package AboutInterface.InnerClass.WhyInnerClass;

class ClassA{
    private String name;
    private String gender;
    private int age;

    public ClassA(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void declare(){
        System.out.println("I'm "+name+" from ClassA");
    }
}

abstract class ClassB{
    private String name;

    public ClassB(String name) {
        this.name = name;
    }

    public void declare(){
        System.out.println("I'm "+name+" from ClassB");
    }
    public abstract void classBMethod();
}

class MyClass extends ClassA{
    private int id;
    private static int nextId=0;
    {
        nextId++;
        id=nextId;
    }

    public MyClass(String name, String gender, int age) {
        super(name, gender, age);
    }

    public ClassB makeClassB(){
        return new ClassB("Tiny") {
            @Override
            public void classBMethod() {
                System.out.println("MyClass Extends ClassB By InnerClass!");
            }
        };
    }
}

public class MultiClasses {
    public static void DeclareA(ClassA a){
        a.declare();
    }
    public static void DeclareB(ClassB b){
        b.declare();
    }
    public static void main(String[] args) {
        MyClass myclass = new MyClass("Amy","Male",18);
        DeclareA(myclass);
        DeclareB(myclass.makeClassB());
        myclass.makeClassB().classBMethod();
    }
}
