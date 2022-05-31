package AboutInterface;

public class Student implements Person , Named{
    public static void main(String[] args) {
        System.out.println(new Student().getName());
    }
}
