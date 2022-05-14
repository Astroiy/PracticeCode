package ConstructorAndInitialization;

public abstract class Person {

    private String name;

    public Person(){};

    public Person(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    };
    public void setName(String name){
        this.name=name;
    }

    protected abstract String getDescription();
}
