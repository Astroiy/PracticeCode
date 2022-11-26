package LearnMaps;


import java.util.TreeMap;

public class MapAndCompute {
    public static void main(String[] args) {
        TreeMap<String,Integer> order = new TreeMap<>();
        order.put("First",1);
        order.put("Second",2);
        order.put("Third",3);
        order.put("Fourth",4);
        order.put("Fifth",5);
        order.put("Null1",null);
        order.put("Null2",null);

        Integer return1 = order.computeIfAbsent("Fifth",(k)->k.length()+order.get(k));
        System.out.println(order.get("Fifth"));
        System.out.println(return1);

        Integer return3 = order.computeIfAbsent("Null1",String::length);
        System.out.println(order.get("Null1"));
        System.out.println(return3);

        Integer return2 = order.computeIfPresent("Fifth",(k,v)->k.length()+v);
        System.out.println(order.get("Fifth"));
        System.out.println(return2);

        Integer return4 = order.computeIfPresent("Null2",(k,v)->k.length()+v);
        System.out.println(order.get("Null2"));
        System.out.println(return4);

        Integer return5 = order.compute("Null2",(k,v)->k.length());
        System.out.println("Null2");
        System.out.println(return5);

    }
}
