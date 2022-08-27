package Concurrency.CountDownLatch;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class DriverAndWorker {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("输入工人数量:");
        int n = new Scanner(System.in).nextInt();
        CountDownLatch getOnSignal = new CountDownLatch(1);
        CountDownLatch allAboardSignal = new CountDownLatch(n);

        for(int i=0;i<n;i++) {
            new Thread(new DriverAndWorker().new Worker(getOnSignal, allAboardSignal)).start();
        }

        System.out.println("司机正在启动车辆...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("车辆启动失败");
            System.exit(1);
        }
        System.out.println("车辆启动成功，开启登车信号");
        getOnSignal.countDown();
        allAboardSignal.await();
        System.out.println("全员等车结束,前往下一处工地");
    }

    private class Worker implements Runnable{
        private static int id;
        private final int individualId;
        private final CountDownLatch getOnSignal;
        private final CountDownLatch allAboardSignal;
        public Worker(CountDownLatch getOnSignal,CountDownLatch allAboardSignal){
            this.getOnSignal=getOnSignal;
            this.allAboardSignal=allAboardSignal;
            individualId=id;
            id++;
        }
        @Override
        public void run() {
            try {
                getOnSignal.await();
                System.out.println(individualId+"号工人上车中...");
                Thread.sleep((int)(1000*Math.random()));
                System.out.println(individualId+"号工人上车成功");
            } catch (InterruptedException e) {
                System.out.println(individualId+"号工人上车失败");
            }
            allAboardSignal.countDown();
        }
    }
}

