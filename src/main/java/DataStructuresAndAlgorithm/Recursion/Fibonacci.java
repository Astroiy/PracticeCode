package DataStructuresAndAlgorithm.Recursion;

import java.security.InvalidParameterException;

public class Fibonacci {
    public static int getFn(int n) throws InvalidParameterException{
        if(n<=0)
            throw new InvalidParameterException();
        int fn = 0;
        if(n==1 || n==2)
            fn=1;
        else{
            fn = getFn(n-1)+getFn(n-2);
        }
        return fn;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getFn(i));
        }
    }
}
