package Concurrency.ThreadSafeCollections.Queues;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue<String> strings = new PriorityBlockingQueue<>();
        for(int i=0;i<12;i++){
            strings.add("s");
        }
        System.out.println(strings);
        PriorityBlockingQueue<Object> objects = new PriorityBlockingQueue<>(5);
        for(int i=0;i<6;i++){
            objects.put(i);
        }
        System.out.println(objects);
    }
}
