package Concurrency.ArraysParallel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

public class ParallelPrefix {
    public static void main(String[] args) {
        long[] factorial = new long[]{1,2,3,4,5,6,7,8,9,10};
        Arrays.parallelPrefix(factorial,(x,y)->x*y);
        System.out.println(Arrays.toString(factorial));

        long[] sumSequence = new long[]{3,6,9,12,15,18,21};
        Arrays.parallelPrefix(sumSequence,Long::sum);
        System.out.println(Arrays.toString(sumSequence));

        BigDecimal[] harmonySeries = new BigDecimal[10];
        for (int i = 0; i < harmonySeries.length; i++) {
            harmonySeries[i]=BigDecimal.valueOf(1).divide(BigDecimal.valueOf(i+1),2, RoundingMode.HALF_UP);
        }
        Arrays.parallelPrefix(harmonySeries,BigDecimal::add);
        System.out.println(Arrays.toString(harmonySeries));
        for (int i = 0; i < 10; i++) {
            System.out.printf("%6.2f",Math.log(i+1));
        }
    }
}
