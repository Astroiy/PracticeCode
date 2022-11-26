package clone;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("Harry", 5000);
        original.setHireday(2000, 1, 1);
        Employee copy = original.clone();
        copy.raiseSalary(30);
        copy.setHireday(2022, 5, 13);
        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
