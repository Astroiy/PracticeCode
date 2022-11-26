package GenericClass.GenericMethod;

import GenericClass.LearnWildCard.Employee;
import GenericClass.SimpleGeneric.Pair;

import java.util.function.Supplier;

public class NoBoundsWildcard {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Pair<?> p1 = new Pair<>(new Object(), new Object());
        Pair<?> p2 = new Pair<String>("First","Second");
        Pair<?> p3 = new Pair<Employee>(new Employee("Tiny",35,3000.0),new Employee("Amy",25,2000.0));
        System.out.println(p1.getFirst());
        System.out.println(p2.getFirst());
        System.out.println(p3.getFirst());
        Pair p4 = p2;
        p4.setFirst("Third");
        System.out.println(p2.getFirst());

    }
}
