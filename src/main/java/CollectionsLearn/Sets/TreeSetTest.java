package CollectionsLearn.Sets;

import java.util.*;

public class TreeSetTest {
    public static void main(String[] args) {
        var parts = new TreeSet<Item>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}

class SortedSetTest{
    public static void main(String[] args) {

        TreeSet<String> strings = new TreeSet<>(Arrays.asList("First","Second","Third","Fourth"));

        TreeSet<Item> items = new TreeSet<>();
        items.add(new Item("Toaster",1234));
        items.add(new Item("Widget",4562));
        items.add(new Item("Modem",9912));

        Comparator<? super Item> c1 = items.comparator();
        Objects.requireNonNull(c1);
        TreeSet<Item> items_reversed = new TreeSet<>(c1.reversed());

        System.out.println(strings.first());
        System.out.println(strings.last());

        System.out.println(items.higher(new Item("New",2222)));
        System.out.println(items.lower(new Item("Newer",4562)));

        var iter = strings.descendingIterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+" ");
            iter.remove();
        }
        System.out.println();
        System.out.println(strings);

        var iter1 = items_reversed.iterator();
        while(iter1.hasNext()){
            System.out.print(iter1.next()+" ");
            iter1.remove();
        }

    }
}
