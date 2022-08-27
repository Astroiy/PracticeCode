package LearnStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Filter {
    public static void main(String[] args) {
        var list = new ArrayList<String>(List.of("Tiny","Timi","Amy","Alice","Coraline"));
        var filtered = list.stream().filter(s->s.startsWith("T"));
        System.out.println("FilterMethod:");
        filtered.forEach(s->{
            int code = 0;
            for(char c: s.toLowerCase().toCharArray()){
                code+=c-'a';
            }
            System.out.println(code);
        });

        System.out.println("\nCountMethod: ");

        var filtered1 = list.stream().filter(s->{
            boolean b = false;
            if(s.startsWith("A")){
                System.out.println(s);
                return true;
            }else{
                return false;
            }
        });

        System.out.println("Start with A counts= "+ filtered1.count());


        System.out.println("\nLimitMethod: ");
        System.out.println(list);
        list.stream().limit(2).forEach(System.out::println);

        System.out.println("\nSkipMethod:" );
        System.out.println(list);
        list.stream().skip(2).forEach(System.out::println);

        System.out.println("\nMapMethod: ");
        System.out.println(list);
        list.stream().map(d-> d + d.charAt(0)).forEach(System.out::println);

        System.out.println("\nConcatMethod: ");
        var concat = Stream.concat(list.stream(),new ArrayList<String>(List.of("One","Two","Three")).stream());
        concat.forEach(System.out::println);



    }
}
