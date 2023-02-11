package StreamLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseMapReturnPerson {
    public static void main(String[] args) {
        var names = new ArrayList<String>(List.of("Vin","Marry","Bobby","Tiny","Sonny"));
        var persons = new ArrayList<Person>();
        names.stream().map(Person::new).forEach(persons::add);
        System.out.println(persons);
    }
    public static class CollectStream{
        public static void main(String[] args) {
            var names = new ArrayList<String>(List.of("Vin","Marry","Bobby","Tiny","Sonny"));
            var toList = names.stream().filter(s -> s.startsWith("T")).toList();
            var toArray = names.stream().filter(s->s.length()==5).toArray();
            System.out.println(toList);
            System.out.println(Arrays.toString(toArray));
        }
    }
}
class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


