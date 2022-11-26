package Others;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread1 extends Thread {
    //定义静态变量
    static int a = 0;
    //重写方法
    @Override
    public void run() {
        //让线程睡觉1秒钟
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        //修改变量a的值
        a = 10;
        //打印结果
        System.out.println("1");
    }
}

class MyThread2 extends Thread {
    //重写方法
    @Override
    public void run() {
        //获取变量a的值
        while(true){
            //如果a的结果是10就结束循环
            if(MyThread1.a==10){
                System.out.println("2");
                break;
            }
        }
    }
}

public class Test03{
    public static void main(String[] args){
        new MyThread1().start();
        new MyThread2().start();
    }
}