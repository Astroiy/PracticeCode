package DataStructuresAndAlgorithm.Recursion;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Random;

public class SelectionProblem {
    static long duration=0;
    public static <T extends Comparable<? super T>> T selectK_Largest1(T[] values,int k){
        long start = System.currentTimeMillis();
        if(k > values.length || k<=0)
            throw new InvalidParameterException();
        T[] kth_copy = Arrays.copyOf(values,k);

        /**冒泡排序*/
        for(int i=0;i< k-1;i++){
            boolean b = false;
            for(int j=0;j< k-1-i;j++){
                if(kth_copy[j].compareTo(kth_copy[j+1])>0){
                    T tmp = kth_copy[j];
                    kth_copy[j]=kth_copy[j+1];
                    kth_copy[j+1]=tmp;
                    b = true;
                }
            }
            if(!b)
                break;
        }

        /**比较第k位与剩下元素的大小,然后插入到合适的位置*/
        for(int i=0;i<values.length-k;i++){
            if(kth_copy[k-1].compareTo(values[k+i])>0){
                T insert = values[k+i];
                for(int j=0;j<k-1;j++){
                    if(kth_copy[j].compareTo(insert)>0){
                        kth_copy[j+1]=kth_copy[j];
                        kth_copy[j]=insert;
                        break;
                    }
                }
            }
        }
        duration = System.currentTimeMillis()-start;
        System.out.println("k方法共耗时: "+duration+" 毫秒 ");
        return kth_copy[k-1];
    }

    public static <T extends Comparable<? super T>> T selectK_Largest2(T[] values,int k){
        long start = System.currentTimeMillis();
        for(int i=0;i< values.length-1;i++)
            for(int j=i+1;j<values.length;j++){
                if(values[0].compareTo(values[j])>0){
                    T tmp = values[0];
                    values[0]=values[j];
                    values[j]=tmp;
                }
            }
        duration = System.currentTimeMillis()-start;
        System.out.println("选择排序方法共耗时: "+duration+" 毫秒");
        return values[k-1];
    }

    public static <T extends Comparable<? super T>> T selectK_Largest3(T[] values,int k){
        long start = System.currentTimeMillis();
        for(int i=0;i<values.length-1;i++){
            for(int j=0;j<values.length-1-i;j++){
                if(values[j].compareTo(values[j+1])>0){
                    T tmp = values[j];
                    values[j]=values[j+1];
                    values[j+1]=tmp;
                }
            }
        }
        duration = System.currentTimeMillis()-start;
        System.out.println("冒泡排序方法共耗时: "+duration+" 毫秒");
        return values[k-1];
    }

    public static <T extends Comparable<? super T>> T selectK_Largest4(T[] values,int k){
        long start = System.currentTimeMillis();
        Arrays.sort(values);
        duration = System.currentTimeMillis()-start;
        System.out.println("快速排序方法共耗时: "+duration+" 毫秒");
        return values[k-1];
    }


    public static void main(String[] args) {

        Integer[] i1 = new Integer[1000];
        Integer[] i2 = new Integer[5000];
        Integer[] i3 = new Integer[10000];
        Integer[] i4 = new Integer[20000];
        Integer[] i5 = new Integer[50000];

        Random rand = new Random(47);
        for (int i = 0; i < i1.length; i++) {
            i1[i] = rand.nextInt();
        }
        for (int i = 0; i < i2.length; i++) {
            i2[i] = rand.nextInt();
        }
        for (int i = 0; i < i3.length; i++) {
            i3[i] = rand.nextInt();
        }
        for (int i = 0; i < i4.length; i++) {
            i4[i] = rand.nextInt();
        }
        for (int i = 0; i < i5.length; i++) {
            i5[i] = rand.nextInt();
        }

        System.out.println(selectK_Largest1(i1,500));
        System.out.println(selectK_Largest1(i2,2500));
        System.out.println(selectK_Largest1(i3,5000));
        System.out.println(selectK_Largest1(i4,10000));
        System.out.println(selectK_Largest1(i5,25000));

        System.out.println(selectK_Largest2(i1,500));
        System.out.println(selectK_Largest2(i2,2500));
        System.out.println(selectK_Largest2(i3,5000));
        System.out.println(selectK_Largest2(i4,10000));
        System.out.println(selectK_Largest2(i5,25000));

        System.out.println(selectK_Largest3(i1,500));
        System.out.println(selectK_Largest3(i2,2500));
        System.out.println(selectK_Largest3(i3,5000));
        System.out.println(selectK_Largest3(i4,10000));
        System.out.println(selectK_Largest3(i5,25000));

        System.out.println(selectK_Largest4(i1,500));
        System.out.println(selectK_Largest4(i2,2500));
        System.out.println(selectK_Largest4(i3,5000));
        System.out.println(selectK_Largest4(i4,10000));
        System.out.println(selectK_Largest4(i5,25000));
    }
}