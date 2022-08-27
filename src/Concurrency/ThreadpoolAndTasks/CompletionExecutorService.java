package Concurrency.ThreadpoolAndTasks;


import java.util.Arrays;
import java.util.concurrent.*;

public class CompletionExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorCompletionService<Integer[]> completionService =
                new ExecutorCompletionService<>(executorService);

        int n = 10000;
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) {
            integers[i] = ThreadLocalRandom.current().nextInt(1000);
        }
        Integer[] clone1 = integers.clone();
        Integer[] clone2 = integers.clone();
        Integer[] clone3 = integers.clone();

        Callable<Integer[]> quickSort = () -> {
            Arrays.sort(clone1);
            System.out.println("快速排序完成");
            clone1[0] = 1111;
            return clone1;
        };

        Callable<Integer[]> bubbleSort = () -> {
            int tmp = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (clone2[j] > clone2[j + 1]) {
                        tmp = clone2[j];
                        clone2[j] = clone2[j + 1];
                        clone2[j + 1] = tmp;
                    }
                }
            }
            System.out.println("冒泡排序完成");
            clone2[0] = 2222;
            return clone2;
        };
        Callable<Integer[]> selectionSort = () -> {
            int tmp = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (clone3[i] > clone3[j]) {
                        tmp = clone3[i];
                        clone3[i] = clone3[j];
                        clone3[j] = tmp;
                    }
                }
            }
            System.out.println("选择排序完成");
            clone3[0] = 3333;
            return clone3;
        };
        Future<Integer[]> selection = completionService.submit(selectionSort);
        Future<Integer[]> bubble = completionService.submit(bubbleSort);
        Future<Integer[]> quick = completionService.submit(quickSort);

        System.out.println(completionService.take().get()[0]);
        System.out.println(completionService.take().get()[0]);
        System.out.println(completionService.take().get()[0]);

        executorService.shutdown();
    }
}
