package LearnStream;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayToStream {
    public static void main(String[] args) {
        String[] strings = {"A", "B", "C"};
        Stream<String> words = Stream.of(strings);
        Stream<String> subWords = Arrays.stream(strings,1,3);

        Stream<String> echos = Stream.generate(() -> "echo");
        Stream<Double> randoms = Stream.generate(Math::random);

        BigInteger limit = new BigInteger("10000000");
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.compareTo(limit) < 0, n -> n.add(BigInteger.ONE));

        String s = null;
        Stream<String> nullStream = Stream.ofNullable(s);
        System.out.println(nullStream.count());

        Stream<String> string = Stream.ofNullable("String");
        System.out.println(string.count());

    }
}
