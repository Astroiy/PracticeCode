package Concurrency.ArraysParallel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ParallelSortTest {
    public static void main(String[] args) {
        String[] words = new String[]{"Tiny","Amy","Bobby","Daddy","Alice","Micheal"};
        Arrays.parallelSort(words, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(Arrays.toString(words));

        int[] numbers = new int[8];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=rand.nextInt(20);
        }
        System.out.println(Arrays.toString(numbers));
        Arrays.parallelSort(numbers,numbers.length/2,numbers.length);
        System.out.println(Arrays.toString(numbers));
    }
}
