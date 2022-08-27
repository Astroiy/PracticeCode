package Concurrency.ThreadpoolAndTasks;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService poolDelay = Executors.newScheduledThreadPool(4);

        ScheduledFuture<?> scheduledFuture = poolDelay.scheduleAtFixedRate(() -> {
            System.out.print(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            System.out.print("\r");
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        ExecutorService fixedPool = Executors.newFixedThreadPool(4);
        CountDownLatch awaitComputation = new CountDownLatch(100);
        Callable<Integer> task = ()->{
            Random rand = new Random();
            int sum=0;
            for(int i =0;i<100000;i++){
                sum+=(rand.nextInt(2)==0?-1:1)*i;
            }
            awaitComputation.countDown();
            return sum;
        };
        ArrayList<Callable<Integer>> callables = new ArrayList<>(100);
        for(int i=0;i<100;i++){
            callables.add(task);
        }
        List<Future<Integer>> futures = fixedPool.invokeAll(callables);

        awaitComputation.await();

        for (int i = 0; i < futures.size(); i++) {
            System.out.println("计算结果之一为: "+futures.get(i).get());
        }

        Thread.sleep(5000);
        scheduledFuture.cancel(true);
        System.out.println(scheduledFuture.isCancelled());
        poolDelay.shutdown();
        fixedPool.shutdown();

    }
}
