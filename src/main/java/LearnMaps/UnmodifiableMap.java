package LearnMaps;

import java.util.Map;

public class UnmodifiableMap {
    public static void main(String[] args) {
        Map.Entry<String,Integer> entry1 = Map.entry("First",1);
        Map.Entry<String,Integer> entry2 = Map.entry("First",1);

        Map<String,Integer> map = Map.ofEntries(entry1,entry2);
    }
}
