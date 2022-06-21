package LearcCollections.ViewsAndWrapper;

import java.util.*;

public class SubRanges {
    public static class TestList{
        public static void main(String[] args) {
            List<String> list = new ArrayList<>(List.of("First","Second","Third","Fourth"));
            var sublist = list.subList(0,3);
            System.out.println(sublist);
            sublist.add("Fifth");
            System.out.println(sublist);
            System.out.println(list);
            sublist.add(0,"Zero");
            System.out.println(list);
            sublist.clear();
            System.out.println(list);

        }
    }

    public static class TestSet{
        public static void main(String[] args) {
            NavigableSet<String> set = new TreeSet<String>(Set.of("First", "Second", "Third", "Fourth", "Fifth",
                    "Sixth","Seventh","Eighth","Nine"));
            var max = set.last();
            var min = set.first();
            System.out.println("Min="+min);
            System.out.println("Max="+max);
            System.out.println("higherS="+set.higher("S"));
            System.out.println("lowerS="+set.lower("S"));
            System.out.println("maxS="+set.ceiling("S"));
            System.out.println("minS="+set.floor("S"));

            var subset = set.subSet(min,false,max,false);
            System.out.println("subset="+subset);
            var headSet = set.headSet("Nine",false);
            var tailSet = set.tailSet("Nine",true);
            System.out.println("headSet="+headSet);
            System.out.println("tailSet="+tailSet);
            subset.add("N");
            headSet.add("D");
            tailSet.add("V");
            System.out.println("subSet="+subset);
            System.out.println("headSet="+headSet);
            System.out.println("tailSet="+tailSet);
            System.out.println("originSet="+set);
        }
    }

    public static class TestMap{
        public static void main(String[] args) {
            NavigableMap<String,Integer> map = new TreeMap<>(
                    Map.ofEntries(Map.entry("First",1),Map.entry("Second",2),Map.entry("Third",3),Map.entry("Fourth",4),
                            Map.entry("Fifth",5))
            );
            System.out.println(map);
            System.out.println("MinKey="+map.firstKey());
            System.out.println("MaxKey="+map.lastKey());
            System.out.println("MinEntry: "+map.firstEntry());
            System.out.println("MaxEntry: "+map.lastEntry());
            System.out.println("higherEntry: "+map.higherEntry("Second"));
            System.out.println("lowerEntry: "+map.lowerEntry("Second"));
            System.out.println("ceilingEntry:"+map.ceilingEntry("Second"));
            System.out.println("floorEntry:"+map.floorEntry("Fourth"));

            var entry = map.firstEntry();

            var subMap = map.subMap("Fifth",false,"Third",false);
            var headMap = map.headMap("Fourth",false);
            var tailMap = map.tailMap("Fourth",true);
            subMap.put("N",11);
            headMap.put("F",22);
            tailMap.put("V",33);
            System.out.println(subMap);
            System.out.println(headMap);
            System.out.println(tailMap);
            System.out.println(map);

            System.out.println(entry);
            System.out.println(map.firstEntry());

        }
    }
}
