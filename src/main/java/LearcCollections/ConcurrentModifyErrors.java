package LearcCollections;

import java.util.ArrayList;
import java.util.HashSet;

public class ConcurrentModifyErrors {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");
        for(String s: list){
            System.out.println(s);
            if(s.equals("Fourth"))
                list.remove(s);
        }
        System.out.println(list);
    }
}
