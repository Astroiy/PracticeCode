package LearcCollections;

import java.util.*;

public class CollectionsMethod {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"First","One","Second","Two","Third","Three");
        System.out.println(list);
        Collections.rotate(list,1);
        System.out.println(list);
        Collections.rotate(list,-2);
        System.out.println(list);
        Collections.rotate(list,1);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list,String.CASE_INSENSITIVE_ORDER.reversed());
        System.out.println(list);
        System.out.println(Collections.indexOfSubList(list,new LinkedList<String>(List.of("One","Two"))));
        System.out.println(Collections.indexOfSubList(list,new LinkedList<String>(List.of("Second"))));
        System.out.println(Collections.indexOfSubList(list,new LinkedList<String>(List.of("One","First"))));
        Collections.fill(list,"None");
        System.out.println(list);
    }
}
