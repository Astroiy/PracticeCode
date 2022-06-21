package BigIntegerAndBigDecimal;

import javax.naming.Context;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.jar.JarOutputStream;

public class BigIntegerAndBigDecimal {
    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.valueOf(1000,3);
        System.out.println(bigDecimal);
        System.out.println(BigDecimal.valueOf(0.01D));
        System.out.println(BigDecimal.valueOf(0.09D));
        System.out.println(new BigDecimal("1").divide(new BigDecimal("3"),3, RoundingMode.HALF_UP));
    }
}
