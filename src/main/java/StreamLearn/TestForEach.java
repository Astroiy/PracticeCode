package StreamLearn;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Amy","Tiny","Lisa","Olivia","Micheal"));
        var stream = list.stream();
        stream.forEach(System.out::println);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        list.sort(Comparator.comparingInt(x->-x.length()));
        System.out.println(list);
        list.sort(Comparator.comparing(x->
            new StringBuilder(x).reverse().toString()));
        System.out.println(list);
    }
}
