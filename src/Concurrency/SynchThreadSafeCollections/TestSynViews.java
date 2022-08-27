package Concurrency.SynchThreadSafeCollections;

import java.util.*;


public class TestSynViews {
    public static void main(String[] args) {
        Collection<String> arrayListWrapper = Collections.synchronizedCollection(new ArrayList<String>());
        List<String> listWrapper = Collections.synchronizedList(new LinkedList<String>());
        Set<String> hashSetWrapper = Collections.synchronizedSet(new HashSet<String>());
        NavigableSet<String> treeSetWrapper = Collections.synchronizedNavigableSet(new TreeSet<String>());
        Map<String,Integer> hashMapWrapper = Collections.synchronizedMap(new HashMap<String,Integer>());
        NavigableMap<String, Integer> treeMapWrapper = Collections.synchronizedNavigableMap(new TreeMap<String, Integer>());




    }
}
