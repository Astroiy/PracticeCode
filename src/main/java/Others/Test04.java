package Others;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread extends Thread {
    //定义初始值为0
    static AtomicInteger ai = new AtomicInteger(0);
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //给变量加一
            ai.addAndGet(1);
        }
    }
}

public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        new MyThread().start();
        new MyThread().start();

        Thread.sleep(1000);

        System.out.println(MyThread.ai);
    }
}
