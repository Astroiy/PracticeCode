package LearnMaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PutAndReplace {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(Map.of("First",1,"Second",2,"Third",3));
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);
        Iterator<Map.Entry<String, Integer>> it = entries.iterator();
        Map.Entry<String, Integer> entry = it.next();
        System.out.println(entry);
        map.put("First",11);
        System.out.println(entry);
        map.replace("First",111);
        System.out.println(entry);
        map.replace("First",111,1111);
        System.out.println(entry);
        map.put("First",1);
        System.out.println(entry);
        map.replaceAll((x,y)->x.length()+y);
        System.out.println(map);
    }
}
