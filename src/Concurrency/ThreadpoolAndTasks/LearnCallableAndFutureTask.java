package Concurrency.ThreadpoolAndTasks;

import java.util.concurrent.*;

public class LearnCallableAndFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Double> task = ()->{
            System.out.println("开始计算...");
            double sum=0.0d;
            for(int i=1;i<=10000;i++){
                sum+=1.0/i;
                Thread.sleep(1);
            }
            return sum;
        };

        FutureTask<Double> computeHarmonySeries = new FutureTask<>(task);

        Thread t = new Thread(computeHarmonySeries);
        t.start();

        new Thread(()->{
            while (true) {
                if(computeHarmonySeries.isDone()) {
                    try {
                        System.out.println("计算已完成");
                        System.out.println("计算结果为: "+computeHarmonySeries.get());
                        break;
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        System.out.println("等待计算结果中...");
        System.out.println("主线程继续执行其他任务...");


    }
}
