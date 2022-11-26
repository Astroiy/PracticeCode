package Concurrency.Thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class RunAndException {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程"+t.getName()+"出现异常"+e.getMessage());
                System.out.println("线程"+t.getName()+"已终止");
            }
        });

        Runnable r = new Runnable() {
            @Override
            public void run()  {
                try {
                    FileInputStream stream = new FileInputStream("aaaaa");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        try {
            new Thread(r).start();
        }catch(Throwable t){
            t.printStackTrace();

        }

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(new Date());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };



        new Thread(r1).start();

    }
}
