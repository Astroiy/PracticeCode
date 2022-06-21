package LearcCollections.ViewsAndWrapper;

import java.util.*;

public class UnmodifiableViews {
    public static void main(String[] args) {
        var list = new ArrayList<String>(List.of("First","Second","Third","Fourth"));
        Collection<String> collection = Collections.unmodifiableCollection(list);
        collection.forEach(System.out::println);
        System.out.println(collection.contains("First"));
        var arr = collection.toArray();
        System.out.println(Arrays.toString(arr));

        var map = new LinkedHashMap<String,Integer>(Map.of("First",1,"Second",2,"Third",3));
        Map<String,Integer> safeMap = Collections.unmodifiableMap(map);
        System.out.println(safeMap.get("Second"));
        System.out.println(safeMap.containsKey("Third"));
        System.out.println(safeMap.containsValue(5));

    }
}
