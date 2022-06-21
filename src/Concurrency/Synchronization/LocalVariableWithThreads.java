package Concurrency.Synchronization;

public class LocalVariableWithThreads {
    public static  int i=0;
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(i);
            i++;
        });
    }
}
