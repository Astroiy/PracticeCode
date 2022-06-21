package GenericClass.SimpleGeneric;

import GenericClass.LearnWildCard.Employee;

import java.lang.reflect.Array;
import java.util.function.IntFunction;

public class ArrayAlgorithm{
    public static <T extends Comparable<? super T>> Pair<T> min_max(T[] t){
        if(t==null || t.length==0)
            return null;
        T min = t[0];
        T max = t[1];
        for(int i=1;i<t.length;i++){
            if(min.compareTo(t[i])>0)
                min=t[i];
            if(max.compareTo(t[i])<0)
                max=t[i];
        }
        return  new Pair<>(min,max);
    }

    public static <T extends Comparable<T>> T[] min_max_arr(T[] t){
        if(t==null || t.length==0)
            return null;
        return null;
    }

    public static <T extends Comparable<T>> T[] min_max_pro(IntFunction<T[]> conStr, T...t){
        if(t==null || t.length==0){
            return null;
        }
        T[] result = conStr.apply(2);
        result[0] = t[0];
        result[1] = t[0];
        for (int i = 1; i < t.length; i++) {
            if(result[0].compareTo(t[i])>0)
                result[0] = t[i];
            if(result[1].compareTo(t[i])<0)
                result[1] = t[i];
        }
        return result;
    }

    public static <T extends Comparable<T>> T[] min_max_traditional(T...t){
        if(t==null || t.length==0){
            return null;
        }
        T[] result = (T[]) Array.newInstance(t.getClass().getComponentType(),2);
        result[0] = t[0];
        result[1] = t[0];
        for (int i = 1; i < t.length; i++) {
            if(result[0].compareTo(t[i])>0)
                result[0] = t[i];
            if(result[1].compareTo(t[i])<0)
                result[1] = t[i];
        }
        return result;
    }
    public static <T extends Employee,U extends Employee> void swapSalary(T t, U u){
        Double tmpSalary = t.getSalary();
        t.setSalary(u.getSalary());
        u.setSalary(tmpSalary);
    }
}