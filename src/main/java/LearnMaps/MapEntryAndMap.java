package LearnMaps;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.DoubleToIntFunction;

import static java.util.Map.Entry.comparingByKey;

public class MapEntryAndMap {
    public static void main(String[] args) {
        TreeMap<String,Integer> orders = new TreeMap<>();
        orders.put("First",1);
        orders.put("Second",2);
        orders.put("Third",3);
        orders.put("Fourth",4);
        orders.put("Fifth",5);

        Set<Map.Entry<String,Integer>> entries =orders.entrySet();
        System.out.println(orders);
        Map.Entry<String,Integer> second=null;
        for(Map.Entry<String,Integer> entry:entries){
            System.out.print(entry+" ");
            if(entry.getKey().equals("Second")){
                entry.setValue(8);
                second = entry;
            }
        }
        System.out.println();
        System.out.println(orders);
        second.setValue(10);
        System.out.println(orders);
        orders.put("Second",12);
        System.out.println(second);
        orders.put("Sixth",6);
        System.out.println(entries);
        entries.remove(second);
        System.out.println(orders);
        entries.remove(Map.entry("Third",3));
        System.out.println(orders);
    }
}
