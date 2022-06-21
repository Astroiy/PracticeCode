package DataStructuresAndAlgorithm.Recursion;

import java.math.BigInteger;
import java.security.InvalidParameterException;

public class ComputeFactorial {
    public static long getValue(long n){
        if(n<0)
            throw new InvalidParameterException();
        long result=1;
        if(n>1){
            result*=n*getValue(n-1);
        }
        return result;
    }

    public static BigInteger BigCombination(long n,long m){
        if(n<=0 || m<0 || m>n)
            throw new InvalidParameterException();
        BigInteger result = new BigInteger("1");
        long tmp = m;
        while(m!=0){
            result=result.multiply(BigInteger.valueOf(n--)).divide(BigInteger.valueOf(tmp-(--m)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getValue(5));
        System.out.println(getValue(6));
        System.out.println(getValue(7));
        System.out.println(getValue(8));

        System.out.println(BigCombination(5,3));
        System.out.println(BigCombination(6,4));
        System.out.println(BigCombination(7,4));

    }
}
