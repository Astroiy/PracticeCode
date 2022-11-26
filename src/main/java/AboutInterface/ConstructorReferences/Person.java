package AboutInterface.ConstructorReferences;

import java.util.Arrays;
import java.util.Comparator;

public class Person {
    private String name;
    public Person(){}
    public Person(String name){this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Name: "+getName();
    }
}
class PersonTest{
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Tiny");
        people[1] = new Person("Amy");
        people[2] = new Person("Bunny");
        System.out.println(Arrays.toString(people));
        Person[] people_clone1 = people.clone();
        Person[] people_clone2 = people.clone();

        Arrays.sort(people, (x,y)->x.getName().length()-y.getName().length());
        Arrays.sort(people, Comparator.comparingInt(x -> x.getName().length()));
        System.out.println(Arrays.toString(people));

        Arrays.sort(people_clone1, Comparator.comparing(Person::getName));
        System.out.println(Arrays.toString(people_clone1));

        Arrays.sort(people_clone2,(x,y)->x.getName().compareToIgnoreCase(y.getName()));
        System.out.println(Arrays.toString(people_clone2));
    }
}
