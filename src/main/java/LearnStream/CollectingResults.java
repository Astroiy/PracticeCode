package LearnStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
    public static Stream<String> noVowels() throws IOException {
        String contents = Files.readString(Path.of("src\\LearnStream\\alice30.txt"), StandardCharsets.UTF_8);
        List<String> wordList = List.of(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();
        return words.map(s->s.replaceAll("[aeiouAEIOU]","")).filter(s->!s.isBlank());
    }

    public static <T> void show(String label, Set<T> set){
        System.out.println(label+": "+set.getClass().getName());
        System.out.println("["
        +set.stream().limit(10).map(Object::toString).collect(Collectors.joining(","))
        +"]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("\nObject array: "+numbers);

        try{
            var number = (Integer)numbers[0];
            System.out.println("number: "+number);
            System.out.println("The following statement throws an exception:");
            var numbers2 = (Integer[])numbers;
        }catch(ClassCastException e){
            System.out.println(e);
        }


        Integer[] number3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array:"+number3);

        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVowelSet",noVowelSet);

        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet",noVowelTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining: "+result);
        result = noVowels().limit(10).collect(Collectors.joining(","));
        System.out.println("Joining with commas: "+result);

        IntSummaryStatistics summary = noVowels().limit(10).collect(Collectors.summarizingInt(String::length));
        double average = summary.getAverage();
        int maxWordLength = summary.getMax();
        System.out.println("Average word length: "+average);
        System.out.println("Max word length: "+maxWordLength);
        System.out.println("forEach: ");
        noVowels().limit(10).forEach(s->System.out.print(s+" "));
    }
}
