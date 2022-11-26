package GenericClass.LearnWildCard;

public class Employee extends Person{

    private Double salary;

    public Employee(){}


    public Employee(String name, Integer age, Double salary) {
        super(name, age);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+"Employee{" +
                "salary=" + salary +
                '}';
    }
}
