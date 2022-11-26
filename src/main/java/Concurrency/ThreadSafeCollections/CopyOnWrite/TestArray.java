package Concurrency.ThreadSafeCollections.CopyOnWrite;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestArray {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(List.of("One","Two","Three","Four"));

    }
}
