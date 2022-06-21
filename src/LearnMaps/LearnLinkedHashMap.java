package LearnMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class LearnLinkedHashMap {
    public static void main(String[] args) {
        var cache = new LinkedHashMap<String,Integer>(16,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size()>5;
            }
        };
        cache.put("First",1);
        cache.put("Second",2);
        cache.put("Third",3);
        cache.put("Fourth",4);
        cache.put("Fifth",5);
        System.out.println(cache);
        System.out.println(cache.get("First"));
        System.out.println(cache);
        cache.put("Sixth",6);
        System.out.println(cache);


    }
}
