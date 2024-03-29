package Concurrency.ThreadSafeCollections.Queues;

import javax.swing.*;
import java.util.Arrays;

public class UnsafeBank {
    private double[] accounts;

    public UnsafeBank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public void transfer(int from,int to ,double amount){
        if(accounts[from]<amount)
            return;
        System.out.print(Thread.currentThread());
        accounts[from]-=amount;
        System.out.printf(" %10.2f from %d to %d",amount,from,to);
        accounts[to]+=amount;
        System.out.printf(" TotalBalance: %10.2f  CurrentAccountBalance: %10.2f\n",getTotalBalance(),accounts[from]);

    }

    public double getTotalBalance(){
        double sum=0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
