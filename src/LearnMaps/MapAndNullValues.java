package LearnMaps;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapAndNullValues {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        EnumMap<NullTest, Integer> enumMap = new EnumMap<NullTest, Integer>(NullTest.class);
        LinkedHashMap<String, Integer> linkedHashSet = new LinkedHashMap<String, Integer>();
        IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>();
        WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<>();
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();
        ConcurrentSkipListMap<String, Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        hashMap.put("First",null);
        treeMap.put("First",null);
        linkedHashSet.put("First",null);
        identityHashMap.put("First",null);
        weakHashMap.put("First",null);
        enumMap.put(NullTest.ForTesting,null);
        concurrentSkipListMap.put("First",null);
        //concurrentHashMap.put("First",null);   也抛异常
    }
}
enum NullTest{
    ForTesting
}
