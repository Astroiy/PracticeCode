package AboutInterface.ProccessingLambda;

import java.util.Arrays;
public class SortBySomething {
    public static void sortByMax(int[] original,ComparatorMax c){
        int tmp;
        for(int i=0;i<original.length;i++){
            boolean b = false;
            for(int j=0;j<original.length-i-1;j++){
                if(c.find_max(original[j],original[j+1])!=original[j]){
                    tmp=original[j];
                    original[j] = original[j+1];
                    original[j+1]=tmp;
                    b=true;
                }
            }
            if(b==false)
                break;
        }
    }
    public static void main(String[] args) {
        int[] a = {4,2,5,3,1};
        int[] b = {6,11,23,7,2,6,17,9,10};
        SortBySomething.sortByMax(a,Math::max);
        SortBySomething.sortByMax(b,(x,y)->Math.max(x,y));
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
