package Concurrency.Synchronization;

import java.util.Arrays;

public class SynchronizedBank {
    private double[] account;

    public SynchronizedBank(int n,double initialBalance){
        account = new double[n];
        Arrays.fill(account,initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
        while(account[from]<amount)
            wait();
        System.out.print(Thread.currentThread());
        account[from]-=amount;
        System.out.printf(" %10.2f from %d to %d",amount,from,to);
        account[to]+=amount;
        System.out.printf(" Total Balance %10.2f CurrentAccountBalance: %10.2f\n",getTotalBalance(),account[from]);
        notify();
    }

    public synchronized double getTotalBalance(){
        double sum=0;
        for (double a : account) {
            sum+=a;
        }
        return sum;
    }

    public int size(){
        return account.length;
    }
}
