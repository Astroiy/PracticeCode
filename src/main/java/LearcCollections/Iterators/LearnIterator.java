package LearcCollections.Iterators;

import java.util.ArrayList;

public class LearnIterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("i1");
        list.add("i2");
        list.add("i3");
        list.add("i4");
        list.add("i5");
        var it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        String s = it.next();

    }
}
