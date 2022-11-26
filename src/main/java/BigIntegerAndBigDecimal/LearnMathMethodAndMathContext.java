package BigIntegerAndBigDecimal;

import java.math.BigDecimal;
import java.math.MathContext;

public class LearnMathMethodAndMathContext {
    public static void main(String[] args) {
        MathContext mc = new MathContext(3);
        BigDecimal b1 = new BigDecimal("23.141592",mc);
        BigDecimal b2 = new BigDecimal("0.00010000",mc);
        BigDecimal b3 = new BigDecimal("0.00012034",mc);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(mc);
        MathContext mc1 = new MathContext(mc.toString());
        var b4 = new BigDecimal("3.1254",mc1);
        System.out.println(b4);
    }
}
