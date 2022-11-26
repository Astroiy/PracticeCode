package LearcCollections.Iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class IterableAndIterator {
    public static class TestForEach {
        public static void main(String[] args) {
            ArrayList<Integer> i = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
            List<Integer> retrieve = new ArrayList<>();
            System.out.println(retrieve);
            i.forEach(x -> {
                retrieve.add(x);
            });
            System.out.println(retrieve);
        }
    }
    public static class TestForEachRemaining{
        public static void main(String[] args) {
            ArrayList<Integer> i = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
            List<Integer> retrieve = new ArrayList<>();
            var it= i.iterator();
            for (int k=0;k<3;k++){
                it.next();
            }
            it.forEachRemaining(retrieve::add);
            System.out.println(retrieve);
        }
    }
}
