package ConstructorAndInitialization;

import java.time.LocalDate;

public final class Manager extends Employee{

    private double bonus;

    public Manager(){super();};
    public Manager(String name){super(name);}
    public Manager(String name,double salary){
        super(name,salary);
    }
    public Manager(String name,double salary,LocalDate hireday){
        super(name,salary,hireday);
        bonus=0;
    }
    public Manager(String name, double salary, LocalDate hireday,double bonus){
        super(name,salary,hireday);
        this.bonus= bonus;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getSalary(){
        double basesalary = super.getSalary();
        return (basesalary+bonus);
    }

    /**
     * public String getDescription(){
        return "an Manager with a salary of "+this.getSalary();
    }
     */

    public boolean equals(Object otherObject){
        if(!super.equals(otherObject))
            return false;
        Manager other = (Manager) otherObject;
        return bonus ==other.bonus;
    }

    public String toString(){
        return super.toString()
                + "[bonus=" + bonus
                + "]";
    }


    public static class Test{
        public static void main(String[] args){
            Manager boss1 = new Manager("Lias",8000);
            boss1.setBonus(5000);
            Manager boss2 = new Manager("Lisa",7000,LocalDate.of(2020,5,13),2000);
            boss2.setBonus(5000);
            Manager boss3 = new Manager("Whilson",9000,LocalDate.now(),5000);
            System.out.println(boss3);
            System.out.println(boss2);

        }
    }

}
