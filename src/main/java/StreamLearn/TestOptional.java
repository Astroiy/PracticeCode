package StreamLearn;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TestOptional {
    public static void main(String[] args) {
        Stream<String> upperLetters = Stream.of("Z", "C", "B", "D", "F");
        Stream<String> lowerLetters = Stream.of("z", "c", "b", "d", "u");

        Optional<String> max = upperLetters.max(Comparator.naturalOrder());
        Optional<String> min = lowerLetters.filter("A"::equals).min(Comparator.naturalOrder());
        var max_clone1 = max.map(String::toLowerCase);
        var max_clone2 = max.map((x)->1000);
        System.out.println(max);
        System.out.println(max_clone1);
        System.out.println(max_clone2);
        System.out.println(max.orElse("Null"));

        try {
            System.out.println(min.orElseThrow());
        } catch (Exception e) {
            System.out.println("该对象为空对象");
        }
        System.out.println(min.or(()->Stream.of("A","B").min(Comparator.naturalOrder())));

       min.ifPresentOrElse(System.out::println,()->{
           System.out.println("min is empty");
       });
    }

    public static class CreateOptional{
        public static void main(String[] args) {
            Stream<String> forTest = Stream.ofNullable("ForTest");
            Optional<String> first = forTest.findFirst();
        }
    }
}
