package StreamLearn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concat {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("Hello".split(""));
        Stream<String> b = Stream.of("World".split(""));
        Stream<String> combined = Stream.concat(a, b);
        System.out.println(combined.collect(Collectors.toList()));
    }
}
