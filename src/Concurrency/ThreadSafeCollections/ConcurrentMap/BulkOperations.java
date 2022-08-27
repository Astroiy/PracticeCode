package Concurrency.ThreadSafeCollections.ConcurrentMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BulkOperations {
    public static class TestSearch{
        public static void main(String[] args) {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(Map.of("First",1,"Second",2,"Third",3,
                    "Fourth",4,"Fifth",5));

            String result1 = map.searchKeys(2,v->v.length()>5?v:null);
            String result2 = map.searchKeys(2, v -> v.endsWith("rd") ? v : null);
            System.out.println(result1);
            System.out.println(result2);

            Map.Entry<String, Integer> entry = map.search(2, (k, v) -> k.length() + v > 9 ? Map.entry(k, v) : null);
            System.out.println(entry);

        }
    }

    public static class TestForEach{
        public static void main(String[] args) {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(Map.of("First",1,"Second",2,"Third",3,
                    "Fourth",4,"Fifth",5));

            map.forEach(2,(k,v)-> System.out.println(k+" "+v));
            map.forEach(2,(k,v)->k+" "+v,System.out::println);

            map.forEach(2,(k,v)->k.length()+v>8?k+" "+v:null,System.out::println);

        }
    }

    public static class TestReduce{
        public static void main(String[] args) {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(Map.of("First",1,"Second",2,"Third",3,
                    "Fourth",4,"Fifth",5));

            Integer sum = map.reduceValues(2, Integer::sum);
            System.out.println(sum);

            Integer keyLength = map.reduceKeys(2, String::length, Math::max);
            System.out.println(keyLength);

            Integer values = map.reduceValues(2, v -> v < 3 ? null : v, Integer::sum);
            System.out.println(values);

            String keys = map.reduceKeys(2, String::concat);
            System.out.println(keys);
        }
    }
}
