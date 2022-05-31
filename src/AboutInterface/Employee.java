package AboutInterface;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.function.DoubleToIntFunction;

public class Employee implements Cloneable {

    /**域*/
    private String name;
    private double salary;
    private Date hireday1;
    private LocalDate hireday2;

    /**利用clone方法定义对象域
     * 此时构造器需要声明会抛出异常*/
    public Employee() throws CloneNotSupportedException {
    }
    private LocalDate hiredaycloned = ((Employee)clone()).hireday2;

    /**hireday2的变异器和访问器*/
    public LocalDate getHireday2() throws CloneNotSupportedException{
        return ((Employee)this.clone()).hireday2;
    }
    public void setHireday2(LocalDate hireday2) {
        this.hireday2 = hireday2;
    }

    /**变异器与访问器*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireday1() throws CloneNotSupportedException{
        return (Date)(hireday1.clone());
    }

    public void setHireday1(Date hireday1) {
        this.hireday1 = hireday1;
    }

    /**覆盖toString方法*/
    public String toString(){
        return "name="+name+" "+"salary="+salary;
    }

    /**测试用内嵌类*/
    public static class Test {
        public static void main(String[] args) throws CloneNotSupportedException {
            Employee amy = new Employee();
            amy.setName("Amy");
            amy.setSalary(2000);

            amy.setHireday1(new Date());
            amy.setHireday2(LocalDate.now());

            System.out.println(amy.hireday1);
            System.out.println(amy.hireday2);

            Date cloned = amy.getHireday1();
            cloned.setTime(10000);

            System.out.println(amy.hireday1);
            System.out.println(cloned);

            System.out.println(Employee.class.getName());
            System.out.println(Employee.class.getSimpleName());

            System.out.println(amy.getHireday2());
            System.out.println(amy.hiredaycloned);
        }
    }
}
class EmployeeTest{
    public static void main(String[] args) throws CloneNotSupportedException {
        /*Employee e = new Employee();
        Employee cloned = (Employee)e.clone();*/
    }
}
class CloneArray{
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] i = {1,2,3,4,5};
        int[] i_cloned = i.clone();
        Integer[] I = {1,2,3,4,5,6};
        Integer[] I_cloned = I.clone();
        Employee[] E = new Employee[]{new Employee(),new Employee()};

        int count = 1;
        double base_salary = 1000;
        for(Employee e : E){
            e.setName(Integer.toString(count));
            e.setSalary(base_salary*count);
            count++;
        }
        Employee[] E_cloned = E.clone();

        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(i_cloned));
        System.out.println(Arrays.toString(I));
        System.out.println(Arrays.toString(I_cloned));
        System.out.println(Arrays.toString(E));
        System.out.println(Arrays.toString(E_cloned));

        System.out.println("=============================");

        i_cloned[0] = 0;
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(i_cloned));
        I_cloned[0] = 0;
        System.out.println(Arrays.toString(I));
        System.out.println(Arrays.toString(I_cloned));
        E_cloned[0].setName("changed");
        System.out.println(Arrays.toString(E));
        System.out.println(Arrays.toString(E_cloned));
        System.out.println(E.hashCode()+" "+E_cloned.hashCode());
    }
}