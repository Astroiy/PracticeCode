package CollectionsLearn.ViewsAndWrapper;

import java.util.HashMap;

public class ViewsOfMap {
    public static void main(String[] args) {
        HashMap<String,Integer> orders = new HashMap<>();
        orders.put("First",1);
        orders.put("Second",2);
        orders.put("Third",3);
        orders.put("Fourth",4);
        orders.put("Fifth",5);

        var sets = orders.keySet();
        var values = orders.values();
        var entrySet = orders.entrySet();

        System.out.println(orders);
        sets.remove("First");
        System.out.println(orders);
        values.remove(3);
        System.out.println(orders+"\n");

        orders.put("Sixth",6);
        System.out.println(sets);
        System.out.println(values+"\n");

        orders.remove("Second");
        System.out.println(sets);
        System.out.println(values);

    }
}
