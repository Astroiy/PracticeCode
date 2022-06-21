package Concurrency.Atomics;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {
    public static void main(String[] args) throws InterruptedException {
        var adder = new LongAdder();
        var start = System.currentTimeMillis();
        int j;
        boolean end = false;
        for (j=0;j<10000;j++) {
            new Thread(()->{
                for(int i=0;i<10000;i++){
                    adder.increment();
                }
            }).start();
            if(j==9999)
                end = true;
        }

        Thread.sleep(10);
        if(end) {
            System.out.println(adder);
            System.out.println("共耗时" + (System.currentTimeMillis() - start) + "毫秒");
        }
    }
}

class AtomicLongComparison{
    public static void main(String[] args) throws InterruptedException {
        var atomic = new AtomicLong(0);
        var start = System.currentTimeMillis();
        int j;
        boolean end = false;
        for (j=0;j<10000;j++) {
            new Thread(()->{
                for(int i=0;i<10000;i++){
                    atomic.addAndGet(1);
                }
            }).start();
            if(j==9999)
                end=true;
        }
        Thread.sleep(300);
        if(end) {
            System.out.println(atomic);
            System.out.println("共耗时" + (System.currentTimeMillis() - start) + "毫秒");
        }
    }
}
