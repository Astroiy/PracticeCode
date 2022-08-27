package LearnStream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctElement {
    public static void main(String[] args) {
        Stream<String> letters = Stream.of("abcbddcbsa".split(""));
        System.out.println(letters.distinct().collect(Collectors.toList()));
    }
}
