package Concurrency.Atomics;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;

public class MaxAndMinByLongAccumulator {

    public static void main(String[] args) {
        var adder = new LongAccumulator(Long::max,0);
        long start = System.currentTimeMillis();
        for(int i = 0;i<10000;i++) {
            Random rand = new Random();
            new Thread(() -> {
                for(int j=0;j<1000000;j++) {
                    adder.accumulate(rand.nextLong(1000));
                }
            }).start();
        }
        System.out.println(adder.get());
        System.out.println("共耗时: "+(System.currentTimeMillis()-start)+"毫秒");

    }
}

class MaxAndMinByAtomicLong{
    public static void main(String[] args) {
        var atomic = new AtomicLong();
        long start = System.currentTimeMillis();
        for(int i = 0;i<10000;i++) {
            Random rand = new Random();
            new Thread(() -> {
                for(int j=0;j<20000;j++) {
                    atomic.accumulateAndGet(rand.nextLong(1000),Math::max);
                }
            }).start();
        }
        System.out.println(atomic);
        System.out.println("共耗时: "+(System.currentTimeMillis()-start)+"毫秒");
    }
}
