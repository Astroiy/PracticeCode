package Concurrency.ArraysParallel;

import java.util.Arrays;
import java.util.Random;

public class ParallelSetAll {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        Arrays.parallelSetAll(numbers,i->new Random(i).nextDouble(i+20));
        for (double v : numbers) {
            System.out.printf("%5.2f ",v);
        }
        int[] mod = new int[15];
        Arrays.parallelSetAll(mod,i->i%10);
        System.out.println("\n"+Arrays.toString(mod));

        String[] words = new String[8];
        Arrays.parallelSetAll(words,i->{
            return switch (i) {
                case 0 -> "Zero";
                case 1 -> "First";
                case 2 -> "Second";
                case 3 -> "Third";
                default -> "TBD";
            };
        });
        System.out.println(Arrays.toString(words));
    }
}
