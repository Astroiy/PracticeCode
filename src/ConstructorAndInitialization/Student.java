package ConstructorAndInitialization;


public class Student extends Person{
    private static int nextId=1;
    private int Id;

    private String major;
    private int age;

    {
        Id=nextId;
        nextId++;
    }

    public Student(String name,int age,String major){
        super(name);
        this.age = age;
        this.major=major;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return Id;
    }

    public String getMajor(){
        return major;
    }
    public String getDescription(){
        return "a student majoring in "+this.getMajor();
    }
    public String toString(){
        return  getClass().getName()
                +"[name="+this.getName()
                +",age="+this.getAge()
                +",major="+this.getMajor()
                +"]";
    }

    public static void triple(Integer x){
        Integer y = x;
        x = 3*x;
        System.out.println(x);
        System.out.println(y);
        System.out.println(x==y);
    }

    public static class Test{
        public static void main(String[] args){
            Student alice = new Student("Alice",15,"Maths");
            Student harry = new Student("Harry",14,"English");
            Student potter= new Student("potter",17,"Physics");
            System.out.println(alice.getName()+" "+alice.getId()+" "+alice.getAge());
            System.out.println(harry.getName()+" "+harry.getId()+" "+harry.getAge());
            System.out.println(potter.getName()+" "+potter.getId()+" "+potter.getAge());
            Integer n =3;
            triple(n);
            System.out.println(n);
        }
    }
}
