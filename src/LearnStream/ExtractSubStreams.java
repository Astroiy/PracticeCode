package LearnStream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtractSubStreams {
    public static void main(String[] args) {
        String string = new String("abacdanowdso");
        Stream<String> letters1 = Stream.of(string.split("")).takeWhile("abcdefghijklmn"::contains);
        System.out.println(letters1.collect(Collectors.toList()));
        Stream<String> letters2 = Stream.of(string.split("")).dropWhile("abcdefghijklmn"::contains);
        System.out.println(letters2.collect(Collectors.toList()));
    }
}
