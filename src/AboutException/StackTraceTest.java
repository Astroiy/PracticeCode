package AboutException;

import AboutInterface.proxy.Stack;

import java.util.Scanner;

public class StackTraceTest {
    public static int factorial(int n){
        System.out.println("factorial("+n+"):");
        var walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        walker.forEach(System.out::println);
        int result;
        if(n==1)
            result=1;
        else{
            result=n*factorial(n-1);
        }
        return result;
    }
    public static void main(String[] args) {
        try(var in = new Scanner(System.in)){
            System.out.println("Enter n: ");
            int n = in.nextInt();
            factorial(n);
        }
    }
}

class StackTraceTest1{
    public static void increment(int n){
        var walker = StackWalker.getInstance();
        walker.forEach(System.out::println);
        if(n<0)
            n+=1;
    }

    public static void main(String[] args) {
        System.out.println("what happened");
        increment(-2);
    }
}
