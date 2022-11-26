package LearcCollections.Lists;

import java.util.*;

public class LearnArrayList {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("Tiny");
        str.add("Amy");
        str.add(null);
        str.add("Another");
        str.add(null);
        System.out.println(str);
        str.remove(null);
        str.add("Tin");
        System.out.println(str);
        String[] str_copy1 = new String[]{"1","2","3","4","5","6","7"};
        String[] str_copy2 = new String[]{"1","2","3","4"};
        String[] result1 = str.toArray(str_copy1);
        String[] result2 = str.toArray(str_copy2);
        System.out.println(Arrays.toString(str_copy1));
        System.out.println(Arrays.toString(str_copy2));
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(result1 == str_copy1);
        Object[] obj = str.toArray();
        System.out.println(Arrays.toString(obj));
        String s = (String) obj[0];
    }
}
