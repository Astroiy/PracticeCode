package AboutInterface;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringArray {
    public static void main(String[] args) {
        String[] string_array = new String[]{"Amy","Tiny","Tin","Harry","Me","Lia"};
        Arrays.sort(string_array, new LengthComparator());
        System.out.println(Arrays.toString(string_array));
    }

}
class LengthComparator implements Comparator<String> {
    public int compare(String first,String second){
        return first.length()-second.length();
    }
}
