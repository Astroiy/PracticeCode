package Concurrency.ThreadSafeCollections.Queues;

import java.util.concurrent.*;

public class TransferInQueue {
    private static final int NANACCOUNTS = 10;
    private static final double INITIAL_BALANCE = 1000;
    private static final double MAX_AMOUNT = 1000;
    private static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new UnsafeBank(NANACCOUNTS,INITIAL_BALANCE);
        TransferQueue<Runnable> queue = new LinkedTransferQueue<>();
        for(int i=0;i<NANACCOUNTS;i++){
            int toAccount = i;
            new Thread(()->{
                while(true) {
                    try {
                        queue.transfer(() -> {
                            int fromAccount = (int) (NANACCOUNTS * Math.random());
                            double amount = MAX_AMOUNT * Math.random();
                            bank.transfer(fromAccount, toAccount, amount);
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        new Thread(()->{
            while(true) {
                try {
                    queue.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
