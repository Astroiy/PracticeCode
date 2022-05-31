package clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireday;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireday = new Date();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.hireday = (Date) hireday.clone();
        return cloned;
    }

    public void setHireday(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireday.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee[" + "name=" + name + ", salary=" + salary + ", hireday=" + hireday + "]";
    }
}
