package ConstructorAndInitialization;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeTest {
    public static double raiseAllSalary(Employee e){
        double base = e.getSalary();
        return base+2000;
    }
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

        Employee[] staff1 = Arrays.copyOf(staff,4);
        var boss = new Manager("Lias",7000,LocalDate.now(),5000);
        boss.setBonus(7000);
        staff1[3] =boss;
        for(Employee e : staff1){
            System.out.println(e.getSalary());
        }

        Employee test1 = new Employee("test1",2000,LocalDate.now());
        Employee test2 = new Manager("test2",5000,LocalDate.now(),2000);
        System.out.println(test1.getSalary());
        System.out.println(test2.getSalary());
        //test2.setBonus(1000);
        ((Manager)test2).setBonus(3000);
        System.out.println(test2.getSalary());

        System.out.println(EmployeeTest.raiseAllSalary(test1));
        System.out.println(EmployeeTest.raiseAllSalary(test2));

        Manager[] managers = new Manager[3];
        Employee[] employees = managers;
        //employees[0] = new Employee("GoManager",2000,2022,1,15);

        System.out.println(test1 instanceof Manager);
        System.out.println(test2 instanceof Employee);
        System.out.println(test2 instanceof Manager);
        Manager test3  = new Manager();
        if(test1 instanceof Manager){
             test3 = (Manager)test1;
        }
        System.out.println(test1.getDescription());
        System.out.println(test2.getDescription());

        Person person = new Employee("Poppy",2000,2020,5,29);
        //person.getSalary();
        System.out.println(person.getDescription());
        System.out.println(person.getName());
        if(person instanceof Employee){
            System.out.println(((Employee) person).getHireday());
        }

        var test4 = new Person[3];
        test4[0] = new Employee("worker",2000,2019,1,25);
        test4[1] = new Manager("manager",5000,LocalDate.now());
        test4[2] = new Student("student",25,"Maths");
        for(Person p :test4){
            System.out.println(p.getName()+" "+p.getDescription());
        }
        Student test5 = new Student("student1",24,"Psychology");
        System.out.println(test5.getName());

        System.out.println(test4[1] instanceof Employee);
        System.out.println(test4[1] instanceof Manager);
        System.out.println(test4[2] instanceof Employee);
        System.out.println(test4[2] instanceof Person);

        System.out.println(test4[2].getClass().getSuperclass());

        var test6 = new ArrayList<Person>(20);
        test6.ensureCapacity(10);
        test6.add(new Employee("arrayworker1",5000,LocalDate.now()));
        test6.add(new Manager("arraymanager",8000,LocalDate.now(),100));
        test6.add(new Student("arraystudent1",18,"Maths"));
        for(Person p :test6){
            System.out.println(p);
        }
        System.out.println();

        test6.add(2,new Employee("arrayworkder2",4000,LocalDate.now()));
        Employee test6_1 = (Employee)test6.get(2);
        System.out.println(test6_1);

        Person test6_2 = test6.set(0,new Student("arraystudent2",17,"English"));
        System.out.println((Employee)test6_2);

        Student test6_3 = (Student)test6.get(0);
        System.out.println(test6_3);

        Person test6_4 = test6.remove(0);
        System.out.println((Student)test6_4);

        test6.trimToSize();
        System.out.println();
        for(Person p :test6){
            System.out.println(p);
        }
        System.out.println(test6.size());





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
