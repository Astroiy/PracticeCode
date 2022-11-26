package AboutInterface;

public class Student extends ForName implements Person , Named{
    public static void main(String[] args) {
        new Student().getName();
    }
    /*public String getName(){
        return Person.super.getName();
    }*/

   /* public String getName1(){
        return Named.super.getName();
    }*/

}
