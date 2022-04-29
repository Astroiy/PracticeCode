package ConstructorAndInitialization;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireday;

    private static int nextId;
    private int id;
    public Employee(String name){
        this.name = name;
    };
    public Employee(String name,double salary,LocalDate hireday){
        if(name==null)
            this.name="unknown";
        else
            this.name = name;
        this.salary=salary;

        this.hireday = Objects.requireNonNull(hireday,"The hireday cannot be null");

    }
    public Employee(String name,double salary,int year,int month,int day){

        this.name = Objects.requireNonNullElse(name,"unknown");
        this.salary=salary;
        this.hireday=LocalDate.of(year,month,day);
    }

    public Employee(String name,double salary){
        this.salary = salary;
        this.name = Objects.requireNonNullElse(name,"unknown");

    }
    public Employee(double salary, LocalDate hireday){
        this(null,salary);
        this.hireday=hireday;
    }


    public String getName(){return name;}
    public double getSalary(){return salary;}
    public LocalDate getHireday(){return hireday;}
    public int getId(){return id;}
    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary+=raise;
    }
     public String toString(){
        return String.join(" ","Name:"+this.name,"Salary:"+String.valueOf(this.salary),"Hireday"+this.hireday.toString()+"\n");
    }

}
