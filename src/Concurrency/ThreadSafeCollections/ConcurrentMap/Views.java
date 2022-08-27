package Concurrency.ThreadSafeCollections.ConcurrentMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Views {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(Map.of("First",1,"Second",2,"Third",3,
                "Fourth",4,"Fifth",5));

        ConcurrentHashMap.KeySetView<String, Integer> view = map.keySet();
        System.out.println(view);

        ConcurrentHashMap.KeySetView<String, Integer> addableView = map.keySet(10);
        addableView.add("Addition");
        System.out.println(map);
        addableView.add("More");
        System.out.println(map);

    }
}
