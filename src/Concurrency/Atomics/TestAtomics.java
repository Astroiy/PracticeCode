package Concurrency.Atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomics {
    public static AtomicInteger sum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                sum.incrementAndGet();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                sum.incrementAndGet();
            }
        }).start();

        Thread.sleep(500);
        System.out.println(sum);
    }

}

class InAtomics{
    public static int sum=0;

    public static void main(String[] args) throws InterruptedException {
        var lock  = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 100000; i++) {
                        InAtomics.sum += 1;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 100000; i++) {
                        InAtomics.sum+=1;
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        System.out.println(InAtomics.sum);

    }
}
