package AboutInterface.ConstructorReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructPersonList {
    public static void main(String[] args) {
        ArrayList<String> names1 = new ArrayList<>(Arrays.asList("Tiny","Amy","Tim","Michael","Mars","Kevin"));
        Stream<Person> stream = names1.stream().map(Person::new);
        List<Person> people1 = stream.collect(Collectors.toList());
        System.out.println(people1);
        ArrayList<String> names2 = new ArrayList<>(Arrays.asList("Tiny","Amy","Tim","Michael","Mars","Kevin"));
        Stream<Person> stream2 = names2.stream().map(Person::new);
        Person[] people2 = stream2.toArray(Person[]::new);
        System.out.println(Arrays.toString(people2));
    }
}
