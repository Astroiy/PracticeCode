package Concurrency.Synchronization;

public class LearnNotify {
    public static synchronized void print(){
        System.out.println("Print");
    }
    public static void main(String[] args) {
        new Thread(()->{
            var lock1 = new LearnNotify();
            var lock2 = new LearnNotify();
            for (int i = 0; i < 100; i++) {
                print();
                synchronized (lock1) {
                    lock1.notifyAll();
                    lock2.notify();
                    LearnNotify.class.notify();
                }
            }
        }).start();
    }
}
