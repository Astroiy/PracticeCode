package BigIntegerAndBigDecimal;

import java.math.BigDecimal;

public class ConstructBigDecimal {
    public static void main(String[] args) {
        char[] ch = new String("8521.0267").toCharArray();
        // char[] ch1 = new char[]{'1','a','.','3'};
        //BigDecimal a = new BigDecimal(ch1,0,1);
        //BigDecimal a1 = new BigDecimal(ch1,0,2);
        BigDecimal b1 = new BigDecimal(ch,0,1);
        BigDecimal b2 = new BigDecimal(ch,0,2);
        BigDecimal b3 = new BigDecimal(ch,0,3);
        BigDecimal b4 = new BigDecimal(ch,0,5);
        BigDecimal b5 = new BigDecimal(ch,0,7);
        BigDecimal b6 = new BigDecimal(ch,0,9);
        //BigDecimal b7 = new BigDecimal(ch,0,11);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
        //System.out.println(b7);  抛异常NumberFormatException

    }
}
