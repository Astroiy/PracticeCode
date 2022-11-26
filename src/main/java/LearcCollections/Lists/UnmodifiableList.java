package LearcCollections.Lists;

import java.util.ArrayList;
import java.util.List;

public class UnmodifiableList {
    public static void main(String[] args) {
        var l1 = List.of("First","Second");
        var l2 = List.of("First","Second");
        var l3 = List.of("First","Second");
        var l4 = List.of("First","Second");
        var l5 = List.copyOf(l4);

        ArrayList<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);

        for(int i = 0;i<4;i++){
            for(int j=i+1;j<5;j++){
                System.out.println(list.get(i).equals(list.get(j)));
            }
        }
    }
}
