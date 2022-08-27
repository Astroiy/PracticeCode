package LearnStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectResults {
    public static void main(String[] args) throws IOException {
        /*使用遍历器遍历结果流*/
        String text = Files.readString(Path.of("src\\LearnStream\\alice30.txt"), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(text.split("\\PL+"));
        Iterator<String> it = words.filter(s -> s.contains("cal")).distinct().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static class TestForEach{
        public static void main(String[] args) throws IOException {
            /*使用ForEach遍历操作*/
            String text = Files.readString(Path.of("src\\LearnStream\\alice30.txt"), StandardCharsets.UTF_8);
            Stream<String> words = Stream.of(text.split("\\PL+"));
            words.filter(s -> s.contains("cal")).distinct().forEach(System.out::println);
        }
    }

    public static class StoreInArray{
        public static void main(String[] args) throws IOException {
            /*流结果存入数组*/
            String text = Files.readString(Path.of("src\\LearnStream\\alice30.txt"), StandardCharsets.UTF_8);
            Stream<String> words1 = Stream.of(text.split("\\PL+"));
            Stream<String> words2 = Stream.of(text.split("\\PL+"));
            Stream<String> words3 = Stream.of(text.split("\\PL+"));
            Stream<String> words4 = Stream.of(text.split("\\PL+"));
            /*不能在运行时创建泛型数组*/
            Object[] cals = words1.filter(s -> s.contains("cal")).distinct().toArray();
            System.out.println(Arrays.toString(cals));
            /*通过传递构造器获得正确类型*/
            String[] cals1 = words2.filter(s -> s.contains("cal")).distinct().toArray(String[]::new);
            System.out.println(Arrays.toString(cals1));
            /*指定不同的长度*/
            String[] cals3 = words4.filter(s -> s.contains("cal")).distinct().toArray(l -> new String[l + 3]);
            System.out.println(Arrays.toString(cals3));
            String[] cals2 = words3.filter(s -> s.contains("cal")).distinct().toArray(l -> new String[1]);
            System.out.println(Arrays.toString(cals2));
        }
    }

    public static class UseCollector{
        public static void main(String[] args) throws IOException {
            String text = Files.readString(Path.of("src\\LearnStream\\alice30.txt"), StandardCharsets.UTF_8);

            Stream<String> words = Stream.of(text.split("\\PL+")).filter(s->s.contains("cal"));
            Stream<String> words1 = Stream.of(text.split("\\PL+")).filter(s->s.contains("cal"));
            Stream<String> words2 = Stream.of(text.split("\\PL+")).filter(s->s.contains("cal"));
            Stream<String> words3 = Stream.of(text.split("\\PL+")).filter(s->s.contains("cal"));
            Stream<String> words4 = Stream.of(text.split("\\PL+")).filter(s->s.contains("cal"));
            List<String> list = words.toList();
            Set<String> set = words1.collect(Collectors.toSet());
            Collection<String> treeSet = words2.collect(Collectors.toCollection(TreeSet::new));
            String joining = words3.collect(Collectors.joining());
            String delimiter = words4.collect(Collectors.joining(", "));
            System.out.println(list);
            System.out.println(set);
            System.out.println(treeSet);
            System.out.println(joining);
            System.out.println(delimiter);

        }
    }
}
