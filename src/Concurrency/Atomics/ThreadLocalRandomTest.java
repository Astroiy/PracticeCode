package Concurrency.Atomics;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        var adder = new LongAccumulator(Long::max,0);
        long start = System.currentTimeMillis();
        for(int i = 0;i<10000;i++) {
            new Thread(() -> {
                for(int j=0;j<1000000;j++) {
                    adder.accumulate(ThreadLocalRandom.current().nextInt(1000));
                }
            }).start();
        }
        System.out.println(adder.get());
        System.out.println("共耗时: "+(System.currentTimeMillis()-start)+"毫秒");
    }
}

class ThreadLocalRawRandom{
    public static void main(String[] args) {
        var adder = new LongAccumulator(Long::max,0);
        ThreadLocal<Random> rand = ThreadLocal.withInitial(Random::new);
        long start = System.currentTimeMillis();
        for(int i = 0;i<10000;i++) {
            new Thread(() -> {
                for(int j=0;j<1000000;j++) {
                    adder.accumulate(rand.get().nextInt(1000));
                }
            }).start();
        }
        System.out.println(adder.get());
        System.out.println("共耗时: "+(System.currentTimeMillis()-start)+"毫秒");
    }
}
