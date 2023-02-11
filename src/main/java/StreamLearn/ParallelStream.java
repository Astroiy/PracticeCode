package StreamLearn;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {
    @Test
    public void testParallel(){
        List<String> numbers = List.of("One", "Tow", "Three", "Four", "Five", "Six");
        Stream<String> stream = numbers.parallelStream();
        List<String> collect = stream.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testParallelAndComparator(){
        List<String> numbers = List.of("One", "Tow", "Three", "Four", "Five", "Six");
        Stream<String> stream = numbers.parallelStream();
        List<String> collect = stream.sorted(Comparator.comparing(w -> w.charAt(w.length() - 1))).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testExchangeParallel(){
        IntStream stream = IntStream.of(1, 3, 5, 2, 4, 6, 4, 6, 8);
        if(!stream.isParallel()){
            System.out.println("转换为并行流");
            stream=stream.parallel();
        }
        System.out.println(stream.isParallel());
        stream.forEach(System.out::println);
    }

    @Test
    public void testWordArray(){
        String[] wordArray = {"First","Second","Three","Four","Five"};
        Stream<String> stream = Stream.of(wordArray).parallel();
        stream.forEach(System.out::println);
    }
    @Test
    public void testShortWord() throws IOException {
        int[] shortWords = new int[12];
        String contents = Files.readString(Paths.get("src/LearnStream/alice30.txt"));
        Stream.of(contents.split("\\PL+")).parallel().forEach(
                s->{
                    if(s.length()<12)
                        shortWords[s.length()]++;});
        System.out.println(Arrays.toString(shortWords));
    }

    @Test
    public void testCountShortWord() throws IOException {
        String contents = Files.readString(Paths.get("src/LearnStream/alice30.txt"));
        Map<Integer, Long> map = Arrays.stream(contents.split("\\PL+")).parallel().filter(s -> s.length() < 12).collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map);
    }

    @Test
    public void testUnordered(){
        IntStream.rangeClosed(0,1000).parallel().limit(20).forEach(System.out::println);
    }

    @Test
    public void testCollectValue() throws IOException {
        String contents = Files.readString(Paths.get("src/LearnStream/alice30.txt"));
        ConcurrentMap<Integer, Long> map = Arrays.stream(contents.split("\\PL+")).parallel().collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));
        System.out.println(map);
    }

    @Test
    public void testCollectorSummarizing() throws IOException {
        String contents = Files.readString(Paths.get("src/LearnStream/alice30.txt"));
        IntSummaryStatistics statistics = Arrays.stream(contents.split("\\PL+")).collect(Collectors.summarizingInt(i -> {
            if (i.contains("a")) {
                return 0;
            } else {
                return i.length();
            }
        }));
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getSum());
    }

}
