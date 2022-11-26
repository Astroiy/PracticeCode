package Concurrency.Thread;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t1.join();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();



    }
}
