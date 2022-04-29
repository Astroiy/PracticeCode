package ConstructorAndInitialization;

public class Student {
    private static int nextId;
    private int Id;
    private String name;
    private int age;
    {
        Id=nextId;
        nextId++;
    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public int getId(){return Id;}
    public static class Test{
        public static void main(String[] args){
            Student alice = new Student("Alice",15);
            Student harry = new Student("Harry",14);
            System.out.println(alice.getName()+" "+alice.getId()+" "+alice.getAge());
            System.out.println(harry.getName()+" "+harry.getId()+" "+harry.getAge());
        }
    }
}
