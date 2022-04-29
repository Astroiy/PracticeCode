package CombArrayAndDate;

import java.util.*;

public class Comb {
    private static int b = 1;
    public static int combination(int n,int m){
        for(int i=1;i<=m;i++)
            b=b*(n-i+1)/i;
        return b;
    }
    public static void resetb(){
        b=1;
    }
    public static void main(String[] args){
        resetb();
        System.out.println(combination(5,3));
    }
}
