import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatStrings {

    public static String concatSimpleMethod(){
        List<Integer> integers = List.of(3, 5, 7);
        return "("+String.join(","+integers.get(0)+"",integers.get(1)+"",integers.get(2)+"")+")";
    }

    public static <E> String concatByStream(Collection<E> values){
        return values.stream().map(Object::toString).collect(Collectors.joining(",", "(", ")"));
    }

    public static void main(String[] args) {
        List<Integer> integers=List.of(3,5,7);
        String s = concatByStream(integers);
        System.out.println(s);
        List<String> strings = Arrays.stream("樊祥优是个大美人".split("")).toList();
        System.out.println(concatByStream(strings));

    }
}

