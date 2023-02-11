package StreamLearn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestPeek {
    public static void main(String[] args) {
        Object[] powers = Stream.iterate(1.0,p->p*2).peek(e-> System.out.println("Fetching "+e)).limit(20).toArray();

        Stream<Double> peek = Stream.iterate(1.0, p -> p * 3).limit(20).peek(e ->{return;});
        List<Double> collect = peek.collect(Collectors.toList());
        System.out.println(collect);

    }
}
