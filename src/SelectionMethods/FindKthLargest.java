package SelectionMethods;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FindKthLargest {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter k");
        long k = in.nextLong();
        double[] values = new double[100000];
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextDouble();
        }
        double[] values_cloned1 = values.clone();
        double[] values_cloned2 = values.clone();

        long bubbleStartTime = System.currentTimeMillis();
        values=BubbleSort.sort(values);
        long bubbleEndTime = System.currentTimeMillis()-bubbleStartTime;

        long selectionStartTime = System.currentTimeMillis();
        values_cloned1=BubbleSort.sort(values_cloned1);
        long selectionEndTime = System.currentTimeMillis()-selectionStartTime;

        long quicksortStartTime = System.currentTimeMillis();
        Arrays.sort(values_cloned2);
        long quicksortEndTime = System.currentTimeMillis()-bubbleStartTime;

        System.out.println("冒泡排序第"+k+"位: "+values[(int)k]+" 共耗时:"+bubbleEndTime);
        System.out.println("选择排序第"+k+"位: "+values_cloned1[(int)k]+" 共耗时:"+selectionEndTime);
        System.out.println("快速排序第"+k+"位: "+values_cloned2[(int)k]+" 共耗时:"+quicksortEndTime);





    }
}
