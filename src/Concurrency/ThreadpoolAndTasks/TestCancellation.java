package Concurrency.ThreadpoolAndTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestCancellation {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Callable<Integer> task = () -> {
            int result = Integer.MIN_VALUE;
            for(int i=0;i<50;i++) {
                if(Thread.currentThread().isInterrupted())
                    break;
                result = Integer.max(result, ThreadLocalRandom.current().nextInt(100));
                Thread.sleep(100);
            }
            return result;
        };
        ArrayList<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
        for (int i = 0; i < 5; i++) {
            tasks.add(task);
        }


        Future<List<Future<Integer>>> future = pool.submit(() -> {
            try {
                System.out.println("在子线程开始运行线程");
                return pool.invokeAll(tasks);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("等待结果");


        System.out.println("在等待时间内完成: "+pool.awaitTermination(20000,TimeUnit.MILLISECONDS));
        pool.shutdown();
        //pool.shutdownNow();

        System.out.println(pool.isShutdown());
        System.out.println(pool.isTerminated());
        System.out.println(pool);
        System.out.println(future);
        for (int i=0;i<5;i++) {
            System.out.println(future.get().get(i).get());
        }


        /*List<Runnable> runnables = pool.shutdownNow();

        System.out.println(runnables);*/

        /*for (Future<Integer> f : futures) {
            f.cancel(true);
        }
        System.out.println("已执行取消操作");
        Thread.sleep(2000);

        for (Future<Integer> f : futures) {
            System.out.println(f.isDone());
        }*/

    }
}
