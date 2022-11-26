package LearnStream;


import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {

    @Test
    public void testIntStream1(){
        IntStream.of(1, 1, 2, 3, 4).peek(e->{
            System.out.println("正在使用元素:"+e);
        }).mapToDouble(e->e*3.14).forEach(System.out::println);
    }


    @Test
    public void testGenerate(){
        Random random = new Random();
        IntStream.generate(random::nextInt).limit(10).forEach(System.out::println);
    }

    @Test
    public void testIterate(){
        IntStream.iterate(0,i->i<10,i->i=i+1).forEach(System.out::println);
    }

    @Test
    public void testRange(){
        IntStream.range(11,15).forEach(System.out::println);
        IntStream.rangeClosed(5,10).forEach(System.out::println);
    }

    @Test
    public void countWordsLength(){
        String[] strings = {"Tiny", "Amy", "Olivia", "Lisa", "Micheal"};
        IntStream intStream = Arrays.stream(strings).mapToInt(String::length);
        int sum = intStream.sum();
        System.out.println("总字母数量:"+sum);
    }

    @Test
    public void testBoxed(){
        Stream<Integer> boxed = IntStream.of(1, 3, 5, 7, 9, 11, 13, 15).boxed();
        boxed.forEach(System.out::println);
    }

    @Test
    public void testReduction(){
        OptionalDouble average = IntStream.generate(new Random()::nextInt).limit(10).average();
        if(average.isPresent()){
            System.out.println(average.getAsDouble());
        }
    }

    @Test
    public void testSummaryStatistic(){
        IntSummaryStatistics statistics = IntStream.generate(new Random()::nextInt).limit(100).summaryStatistics();
        System.out.println("最大值:"+statistics.getMax());
        System.out.println("最小值:"+statistics.getMin());
        System.out.println("平均值:"+statistics.getAverage());
        System.out.println("统计总数:"+statistics.getCount());
        System.out.println("和:"+statistics.getSum());
    }

    @Test
    public void testRandom(){
        Random random = new Random();
        random.doubles(100,-10.9,33.4).forEach(System.out::println);
    }


}
