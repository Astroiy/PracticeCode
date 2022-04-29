package CombArrayAndDate;

import java.util.*;
public class ForArray {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = Arrays.copyOf(a,6);
        int[] c = Arrays.copyOfRange(a,0,5);
        String[] s1 = {"a","b","c"};
        String[] s2 = Arrays.copyOf(s1,4);
        int[] d  = new int[5];
        Arrays.fill(d,1);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(s2));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.equals(a,b));
    }
}
