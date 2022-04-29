package CombArrayAndDate;

import java.util.Arrays;

public class VarargsType {
    static void f(Object ... args) {
        for (Object obj : args)
            System.out.print(obj + " ");
    }
    static void g(int ... args) {
        for (int i : args)
            System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] i = {1,2,3,4,5};
        char[] ch = {'a','b'};
        long[] l = {6,7,8};
        float[] f = {1.1f,2.2f};
        double[] d = {3.3,4.4};
        boolean[] b = {true,false};
        Integer[] I = new Integer[]{1,2,3,4,5};
        //System.out.println(Arrays.toString(b));
        f((Object)new int[]{1,2,3,4,5});
        f(i);
        f(ch);
        f(l);
        f(f);
        f(d);
        f(b);
        f(I);
        f(new Integer[]{1,2,3,4});
        f();

    }
}
