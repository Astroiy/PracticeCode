package Others;

public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        //定义一个对象当做锁
        Object lock = new Object();
        //线程一
        new Thread(){
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(1);
                    //等待
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                    System.out.println(2);
                }
            }
        }.start();

        //睡眠
        Thread.sleep(1000);

        //线程二
        new Thread(){
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(3);
                    //唤醒
                    lock.notify();
                }
            }
        }.start();
    }
}
