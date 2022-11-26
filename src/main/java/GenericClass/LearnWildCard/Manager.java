package GenericClass.LearnWildCard;

public class Manager extends Employee{

    private Double bonus;

    public Manager() {
    }

    public Manager(String name, Integer age, Double salary, Double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString()+"Manager{" +
                "bonus=" + bonus +
                '}';
    }
}
