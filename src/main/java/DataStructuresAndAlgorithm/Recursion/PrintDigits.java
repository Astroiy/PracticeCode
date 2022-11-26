package DataStructuresAndAlgorithm.Recursion;

import java.math.BigDecimal;

public class PrintDigits {
    public static void printDigit0(long i){
        if(i>=10)
            printDigit0(i/10);
        System.out.print(i%10);
    }
    public static void printRealNumber(double d){
        if(d<0) {
            d = (-1.0) * d;
            System.out.print("-");
        }
        BigDecimal D = BigDecimal.valueOf(d);
        BigDecimal dInteger = BigDecimal.valueOf(D.longValue());
        printDigit0(dInteger.longValueExact());
        BigDecimal dDecimal = D.subtract(BigDecimal.valueOf((long)d));
        if(dDecimal.compareTo(BigDecimal.valueOf(0))!=0)
            System.out.print(".");
        while(dDecimal.compareTo(BigDecimal.valueOf(0))!=0){
            dDecimal=dDecimal.multiply(BigDecimal.valueOf(10));
            System.out.print(dDecimal.intValue());
            dDecimal=dDecimal.subtract(BigDecimal.valueOf(dDecimal.intValue()));
        }
    }
    public static void main(String[] args) {
        printRealNumber(35.263977);
        System.out.println();
        System.out.println(-359.635987);

    }
}
