package GenericClass.GenericMethod;

import java.lang.reflect.Array;

public class ArrayAlg {
    public static <T> T getMiddle(T...t){
        return t[t.length/2];
    }

    public static void main(String[] args) {
    }
}

