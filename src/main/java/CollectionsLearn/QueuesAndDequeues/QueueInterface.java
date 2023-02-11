package CollectionsLearn.QueuesAndDequeues;

import java.util.*;

public class QueueInterface {
    public static void main(String[] args) {
        ArrayDeque<Integer> values = new ArrayDeque<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        var values1 = new ArrayDeque<Integer>(5);
        values1.add(1);
        values1.add(2);
        values1.add(3);
        values1.add(4);
        values1.add(5);
        values1.add(6);
        values1.add(7);
        values1.offer(8);
        System.out.println(values);
        System.out.println(values1);

        var a1 = values.peek();
        var a2 = values.remove();
        var a3 = values.element();
        var a4 = values.poll();

        values.offer(100);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(values);

    }
    public static class TestOthers{
        public static void main(String[] args) {
            var deque = new ArrayDeque<Integer>();
            deque.addFirst(1);
            deque.offerFirst(2);
            deque.push(3);

            deque.addLast(10);
            deque.offerLast(20);

            System.out.println(deque);

            System.out.println(deque.getFirst());
            System.out.println(deque.peek());
            System.out.println(deque.peekFirst());
            System.out.println(deque.peekLast());
            System.out.println(deque.getLast());

            System.out.println(deque.remove());
            System.out.println(deque);
            System.out.println(deque.removeFirst());
            System.out.println(deque);
            System.out.println(deque.pollLast());
            System.out.println(deque);

            System.out.println(deque.pop());


        }
    }
}
