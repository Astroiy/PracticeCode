package Concurrency.Synchronization;

public class TestDeadLocks {
    private static final int NACCOUNTS=10;
    private static final double INITIAL_BALANCE=2000;
    private static final double MAX_AMOUNT=1000;
    private static final int DELAY = 10;

    public static void main(String[] args) {
        var synchronizedBank = new SynchronizedBank(NACCOUNTS,INITIAL_BALANCE);
        for(int i=0;i<NACCOUNTS;i++){
            int fromAccount = i;
            Runnable r = ()->{
                try{
                    while(true){
                        int toAccount = (int)(synchronizedBank.size()*Math.random());
                        double amount = 4*MAX_AMOUNT*Math.random();
                        synchronizedBank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY* Math.random()));
                    }
                }catch(InterruptedException e){

                }
            };
            var t = new Thread(r);
            t.start();
        }
    }
}

class TestDeadLocks2{
    private static final int NACCOUNTS = 10;
    private static final double INITIAL_BALANCE=2000;
    private static final double MAX_AMOUNT= 1000;
    private static final int DELAY=10;
    public static void main(String[] args) {
        var synchronizedBank = new SynchronizedBank(NACCOUNTS,INITIAL_BALANCE);
        for(int i=0;i<NACCOUNTS;i++){
            int toAccount = i;
            Runnable r = ()->{
                try{
                    while(true){
                        int fromAccount = (int)(Math.random()*synchronizedBank.size());
                        double amount = 2*MAX_AMOUNT*Math.random();
                        synchronizedBank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY* Math.random()));
                    }
                }catch(InterruptedException e){

                }
            };
            var t = new Thread(r);
            t.start();
        }
    }
}
