package Concurrency.Synchronization;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeBank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public SafeBank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds=bankLock.newCondition();
    }
    public void transfer(int from,int to,double amount) throws InterruptedException{
        bankLock.lock();
        try{
            while(accounts[from]<amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from]-=amount;
            System.out.printf(" %10.2f from %d to %d",amount,from,to);
            accounts[to] +=amount;
            System.out.printf(" Total Balance: %10.2f fromAccountBalance: %10.2f\n",getTotalBalance(),accounts[from]);
            sufficientFunds.signalAll();
        }finally {
            bankLock.unlock();
        }
    }
    public double getTotalBalance(){
        bankLock.lock();
        double sum =0;
        try{
            for (double account : accounts) {
                sum+=account;

            }
        }finally {
            bankLock.unlock();
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
