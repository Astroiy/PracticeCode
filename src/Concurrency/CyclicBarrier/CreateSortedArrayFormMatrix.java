package Concurrency.CyclicBarrier;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CyclicBarrier;

public class CreateSortedArrayFormMatrix {
    public static void remakeDoubleMatrix(Double[][] data) {
        int n = data.length;
        int m = data[0].length;

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = rand.nextDouble(100.0d);
            }
        }
        System.out.println("待处理矩阵: ");
        for (Double[] row : data) {
            for (Double col : row) {
                System.out.printf("%10.2f ", col);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入矩阵的行数n: ");
        int n = in.nextInt();
        System.out.println("输入矩阵的列数m: ");
        int m = in.nextInt();
        Double[] result = new Double[m];
        Double[][] data = new Double[n][m];
        remakeDoubleMatrix(data);

        DoneHelper helper = new DoneHelper();
        ArrayList<Thread> threads = new ArrayList<>();
        Runnable merge = () -> {
            if(threads.indexOf(Thread.currentThread())==0){
                System.out.println("由" + (threads.indexOf(Thread.currentThread()) + 1) + "号线程负责执行");
                for (int i = 0; i < m; i++) {
                    Double max = data[0][i];
                    for (int j = 0; j < n; j++) {
                        max = Double.max(max, data[j][i]);
                    }
                    result[i] = max;
                }
                if (result[0] < 20 && result[m - 1] > 90) {
                    helper.setB(true);
                    System.out.println("结果如下: ");
                    for (Double aDouble : result) {
                        System.out.printf("%10.2f ", aDouble);
                    }
                    System.out.println();
                } else {
                    System.out.println("结果如下: ");
                    for (Double aDouble : result) {
                        System.out.printf("%10.2f ", aDouble);
                    }
                    System.out.println("\n结果不匹配，重新构造数据");
                    remakeDoubleMatrix(data);
                }
            }
        };

        CyclicBarrier barrier = new CyclicBarrier(n, merge);
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new Sorter<Double>(data[i], barrier, helper, i + 1));
            threads.add(t);
            t.start();
        }

        //如果需要的话，主线程等待所有线程执行结束
        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println(thread.getState());
            } catch (InterruptedException e) {
            }
        }
    }
}

class Sorter<T extends Comparable<? super T>> implements Runnable {
    private final CyclicBarrier cyclicBarrier;
    private final DoneHelper helper;
    private final int order;
    T[] myRow;

    public Sorter(T[] myRow, CyclicBarrier cyclicBarrier, DoneHelper helper, int order) {
        this.myRow = myRow;
        this.cyclicBarrier = cyclicBarrier;
        this.helper = helper;
        this.order = order;
    }

    @Override
    public void run() {
        while (!done(helper.getB())) {
            try {
                Arrays.sort(myRow);
                System.out.println(order + "号线程" + "是第" + cyclicBarrier.await() + "个到达的线程");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean done(boolean criterion) {
        return criterion;
    }
}

class DoneHelper {
    private Boolean b = false;

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }
}
