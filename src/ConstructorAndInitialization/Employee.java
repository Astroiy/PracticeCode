package ConstructorAndInitialization;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person implements Comparable , Cloneable{
    /**Employee对象的实例域*/
   // private String name;
    private double salary;
    private LocalDate hireday;



    /**Employee类的构造器*/
    public Employee(){};
    public Employee(String name){
        super(name);
    };
    public Employee(String name,double salary,LocalDate hireday){
        super(name);
        if(name==null)
           this.setName("unknown");
        else
           this.setName(name);
        this.salary=salary;
        this.hireday = Objects.requireNonNull(hireday,"The hireday cannot be null");

    }
    public Employee(String name,double salary,int year,int month,int day){

        this.setName(Objects.requireNonNullElse(name,"unknown"));
        this.salary=salary;
        this.hireday=LocalDate.of(year,month,day);
    }

    public Employee(String name,double salary){
        this.salary = salary;
        this.setName(Objects.requireNonNullElse(name,"unknown"));

    }
    public Employee(double salary, LocalDate hireday){
        this(null,salary);
        this.hireday=hireday;
    }

    /**Employee类的访问器与变异器*/
    public double getSalary(){return salary;}
    public LocalDate getHireday(){return hireday;}
    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary+=raise;
    }
    /**Employee类的打印方法覆盖*/
   public String toString(){
       return getClass().getName()
               + "[name=" + getName()
               + ",salary=" + getSalary()
               + ",hireDay="+ getHireday()
               + "]";
   }

    protected String getDescription(){
        return "an employee with a salary of "+this.getSalary();
    }

    public boolean equals(Object otherObject){
        if(this == otherObject)
            return true;                    
        else if(otherObject == null)
            return false;
        else if(getClass()!=otherObject.getClass())
            return false;
        Employee other = (Employee) otherObject;
        return Objects.equals(getName(),other.getName())&&Objects.equals(getHireday(),other.getHireday())&&(getSalary()==other.getSalary());
    }

    public int hashCode(){
        return Objects.hash(getName(),salary,hireday);
    }
    /**实现Comparable接口*/
    @Override
    public int compareTo(Object otherObject) {
       Employee otherEmp  = (Employee) otherObject;
       return Double.compare(getSalary(), otherEmp.getSalary());
    }

    /**实现Cloneable接口*/
    @Override
    public Employee clone() throws CloneNotSupportedException{
       return (Employee) super.clone();
    }




}
