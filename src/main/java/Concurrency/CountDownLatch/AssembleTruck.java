package Concurrency.CountDownLatch;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class AssembleTruck {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("输入车辆组件数量: ");
        int n = new Scanner(System.in).nextInt();
        CountDownLatch doneSignal = new CountDownLatch(n);
        for(int i=0;i<n;i++){
            new Thread(new AssembleTruck().new Worker(doneSignal,i)).start();
        }
        System.out.println("司机等待车辆组装中...");
        doneSignal.await();
        System.out.println("组装完成，出发");

    }
    private class Worker implements Runnable{
        private final CountDownLatch doneSignal;
        private final int i;
        public Worker(CountDownLatch doneSignal,int i){
            this.doneSignal = doneSignal;
            this.i=i;
        }

        @Override
        public void run() {
            try {
                System.out.println("正在组装第"+i+"部分组件");
                Thread.sleep((int)(2000*Math.random()));
                System.out.println("第"+i+"部分组装完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doneSignal.countDown();
        }
    }
}
