package Concurrency.ThreadSafeCollections.ConcurrentSet;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class KeySetMethod {
    public static void main(String[] args) {
        Set<String> set = ConcurrentHashMap.<String>newKeySet();

    }
}
