package BigIntegerAndBigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestOperation {
    public static void main(String[] args) {
        BigDecimal d1 =
                new BigDecimal("1").add(new BigDecimal("2.7")).multiply(new BigDecimal("0.1")).divide(new BigDecimal(
                        "3"),3,RoundingMode.HALF_UP);
        BigDecimal d2 =
                new BigDecimal("2").subtract(new BigDecimal("0.01").multiply(new BigDecimal("17.2")).divide(new BigDecimal("3"),3,RoundingMode.HALF_UP)).multiply(new BigDecimal("3"));
        System.out.println(d1);
        System.out.println(d2);
    }
}
