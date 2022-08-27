package Concurrency.ThreadSafeCollections.Queues;

import java.util.Random;
import java.util.concurrent.*;


public class QueuesAndBlockingQueues {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Runnable producer = ()->{
            Random rand = new Random();
            while(!Thread.currentThread().isInterrupted()){
                try {
                    queue.put(rand.nextInt());
                    Thread.sleep((int)(1000*Math.random()));
                    System.out.println(queue.remainingCapacity());
                } catch (InterruptedException e) {
                    System.out.println("t1线程结束");
                    break;
                }
            }
        };
        var t1 = new Thread(producer);
        t1.start();
        Runnable consumer = ()->{
            while(true){
                try {
                    if(queue.isEmpty() && t1.getState().equals(Thread.State.TERMINATED)) {
                        System.out.println("输出线程结束");
                        System.exit(0);
                    }
                    System.out.println(queue.poll(1000,TimeUnit.MILLISECONDS));
                    Thread.sleep((int)(2000*Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(consumer).start();
        while(true) {
            if(queue.remainingCapacity()==0) {
                t1.interrupt();
                break;
            }
        }
        Thread.sleep(1000);
        System.out.println("t1线程状态"+t1.getState());
    }
}
