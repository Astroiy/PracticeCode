package ConstructorAndInitialization;

import java.time.LocalDate;
import java.util.Arrays;

public class EmployeeTest {
    public static void main(String[] args){
        int n = 1;
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Mike",2500,LocalDate.of(2022,04,21));
        staff[1] = new Employee("Rose",3500,LocalDate.of(2022,02,23));
        staff[2] = new Employee("Micheal",3400,LocalDate.of(2022,01,02));
        //ConstructorAndInitialization.Employee[] staff1 = Arrays.copyOf(staff,4);
        //var alice = new ConstructorAndInitialization.Employee(null,1200,LocalDate.of(2022,1,02));
        //var harry = new ConstructorAndInitialization.Employee(null,1200,2022,2,11);
        //var potter = new ConstructorAndInitialization.Employee("Potter");
        //System.out.println(alice);
        //System.out.println(harry.getName());

        var Mini = new Employee(1000,LocalDate.of(2022,2,15));
        System.out.println(Mini.getName()+" "+Mini.getSalary()+Mini.getHireday());
        var Mana = new Employee(2000,LocalDate.of(2022,03,04));
        System.out.println(Mana.getName()+" "+Mana.getSalary()+Mana.getHireday());

        System.out.printf("Before:\n%s",Arrays.toString(staff));

        for(int i=0;i<staff.length;i++)
            staff[i].raiseSalary(30.0);

        System.out.printf("After:\n%s",Arrays.toString(staff));

        // System.out.println("Before:");
       //for(ConstructorAndInitialization.Employee employee: staff)
           // System.out.printf("Name:%s Salary:%8.2f Hireday:%tF\n",employee.getName(),employee.getSalary(),employee.getHireday());



       // System.out.println("After:");
        //for(ConstructorAndInitialization.Employee employee: staff)
           // System.out.printf("Name:%s Salary:%8.2f Hireday:%tF\n",employee.getName(),employee.getSalary(),employee.getHireday());
        }
    public void teset(){}
}
