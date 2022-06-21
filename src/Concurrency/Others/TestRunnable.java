package Concurrency.Others;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class TestRunnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        var t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程1");
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+"剩下"+(4-i)+"秒");
                }
            }
        });
        var t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程2");
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+"剩下"+(4-i)+"秒");
                }
            }
        });

        t1.start();
        t2.start();
    }
    public static class MoreTest1{
        public static void main(String[] args) throws ParseException {
            while(true){
                String sdf =
                        new SimpleDateFormat("HH:mm:ss").format(new SimpleDateFormat("HH:mm:ss").parse("10:30:00").getTime()-System.currentTimeMillis());
                System.out.print(sdf);
                System.out.print("\r");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
