package CombArrayAndDate;

import java.util.Arrays;
public class Search {
    public static void main(String[] args){
        int[] a = {1,4,3,2,6,5,8};
        char[] c = {'b','F','a','Q','q','b'};
        boolean[] bl = {true,false,false,false,true};
        Arrays.sort(a);
        Arrays.sort(c);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.binarySearch(a,3));
        System.out.println(Arrays.binarySearch(a,0,7,8));
        System.out.println(Arrays.binarySearch(c,'U'));
    }
}
