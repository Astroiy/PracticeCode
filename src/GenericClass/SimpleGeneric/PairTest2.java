package GenericClass.SimpleGeneric;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1996,12,9),
                LocalDate.of(1815,12,10),
                LocalDate.of(1903,12,3),
                LocalDate.of(1910,6,22),
        };
        Pair<LocalDate> mm = ArrayAlgorithm.min_max(birthdays);
        System.out.println("min = "+mm.getFirst());
        System.out.println("max = "+mm.getSecond());
        var table = (Pair<String>[]) new Pair<?>[10];
        System.out.println(table.getClass());
        Object[] objarray = table;
        objarray[0] = new Pair<Double>(1.24,3.13);
        //System.out.println(table[0].getFirst());
        var result1 = ArrayAlgorithm.min_max_pro(String[]::new,"Tiny","Amy","Olivia");
        System.out.println(Arrays.toString(result1));
        var result2 = ArrayAlgorithm.min_max_traditional("Tiny","Amy","Olivia");
        System.out.println(Arrays.toString(result2));


    }

}


class TestReflection{
    public static void main(String[] args) throws Throwable{

    }
}