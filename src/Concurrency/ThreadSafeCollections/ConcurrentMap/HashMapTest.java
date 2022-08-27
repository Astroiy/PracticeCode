package Concurrency.ThreadSafeCollections.ConcurrentMap;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class HashMapTest {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(Map.of("One", 1, "Two", 2, "Three", 3));
        CopyOnWriteArrayList<Integer> orderAndEnd = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    map.put("One", map.get("One") + 1);
                    map.put("Two", map.get("Two") + 1);
                    map.put("Three", map.get("Three") + 1);
                    map.put("Four", map.getOrDefault("Four", 0) + 1);
                    if(j==99)
                        orderAndEnd.add(1);
                }
            });

            t.start();
            t.join();
        }
        while (true) {
            if (orderAndEnd.size() == 100) {
                System.out.println(map);
                break;
            }
        }
    }

    public static class UseMerge {
        public static void main(String[] args) throws InterruptedException {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(Map.of("One", 1, "Two", 2, "Three", 3));
            CopyOnWriteArrayList<Integer> orderAndEnd = new CopyOnWriteArrayList<>();

            for (int i = 0; i < 100; i++) {
                new Thread(() -> {
                    for (int j = 0; j < 100; j++) {
                        map.merge("On e", 1, Integer::sum);
                        map.merge("Two", 1, Integer::sum);
                        map.merge("Three", 1, Integer::sum);
                        map.compute("Four", (k, v) -> v == null ? 1 : v + 1);
                        if (j == 99)
                            orderAndEnd.add(1);
                    }
                }).start();
            }
            while (true) {
                if (orderAndEnd.size() == 100) {
                    System.out.println(map);
                    break;
                }
            }
        }
    }

    public static class UseCountDownLatch{
        public static void main(String[] args) throws InterruptedException {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(Map.of("One", 1, "Two", 2, "Three", 3));
            CountDownLatch countDown = new CountDownLatch(100);

            for (int i = 0; i < 100; i++) {
                new Thread(() -> {
                    try {
                        for (int j = 0; j < 100; j++) {
                            map.merge("On e", 1, Integer::sum);
                            map.merge("Two", 1, Integer::sum);
                            map.merge("Three", 1, Integer::sum);
                            map.compute("Four", (k, v) -> v == null ? 1 : v + 1);
                        }
                    } finally {
                        countDown.countDown();
                    }
                }).start();
            }
        }
    }
}
