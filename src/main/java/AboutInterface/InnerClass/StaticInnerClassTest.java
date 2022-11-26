package AboutInterface.InnerClass;

import java.util.Arrays;

public class StaticInnerClassTest {
    /**对于数组方法的测试类*/
    public static class TestArrayMethod {
        public static void main(String[] args) throws EmptyArrayException {
            double Max;
            double Min;
            double[] test = new double[20];
            for (int i = 0; i < test.length; i++) {
                test[i] = Math.random() * 100;
            }
            System.out.println(Arrays.toString(test));
            Max = ArrayAlg.max_min(test)[0];
            Min = ArrayAlg.max_min(test)[1];
            System.out.println(Max);
            System.out.println(Min);

        }
    }
    /**对应嵌套类的测试类*/
    public static class TestNestedClass {
        public static void main(String[] args) throws EmptyArrayException {
            double Max;
            double Min;
            double[] test = new double[20];
            for (int i = 0; i < test.length; i++) {
                test[i] = Math.random() * 100;
            }
            System.out.println(Arrays.toString(test));
            Max = ArrayAlg.max_min_pair(test).getFirst();
            Min = ArrayAlg.max_min_pair(test).getSecond();
            System.out.println(Max);
            System.out.println(Min);
        }
    }
}
class ArrayAlg {
    /**返回数组存储多个结果的静态方法*/
    public static double[] max_min(double[] values) throws EmptyArrayException {
        double[] result = new double[2];
        result[0] = Double.NEGATIVE_INFINITY;
        result[1] = Double.POSITIVE_INFINITY;
        if (values.length == 0)
            throw new EmptyArrayException();
        else {
            for (int i = 0; i < values.length; i++) {
                result[0] = Math.max(result[0], values[i]);
                result[1] = Math.min(result[1], values[i]);
            }
            return result;
        }
    }
    /**使用嵌套类解决该问题,避免重名*/
    public static class Pair {
        private double first;
        private double second;
        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }
        public double getFirst() {return first;}
        public double getSecond() {return second;}
    }
    public static Pair max_min_pair(double[] values) throws EmptyArrayException {
        if (values.length != 0) {
            double Max = Double.NEGATIVE_INFINITY;
            double Min = Double.POSITIVE_INFINITY;
            for (double d : values) {
                if (Max < d) Max = d;
                if (Min > d) Min = d;
            }
            return new Pair(Max, Min);
        } else
            throw new EmptyArrayException();
    }
}
class EmptyArrayException extends Exception {
}
