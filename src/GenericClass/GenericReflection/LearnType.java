package GenericClass.GenericReflection;

import java.lang.reflect.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import GenericClass.SimpleGeneric.*;

public class LearnType {
    public static void main(String[] args) {
       /* System.out.println(Arrays.toString(Class.class.getTypeParameters()));
        System.out.println(Arrays.toString(ArrayList.class.getTypeParameters()));
        System.out.println(Class.class.getTypeParameters()[0].getName());
        System.out.println(ArrayList.class.getTypeParameters()[0].getName());*/

        /*System.out.println(Class.class.getGenericSuperclass());
        System.out.println(ArrayList.class.getGenericSuperclass());
        System.out.println(AbstractList.class.getGenericSuperclass());
        System.out.println(int.class.getGenericSuperclass());
        System.out.println(int[].class.getGenericSuperclass());
        System.out.println(Double[].class.getGenericSuperclass());
        System.out.println(Comparable.class.getGenericSuperclass());
        System.out.println(Comparator.class.getGenericSuperclass());*/

        /*System.out.println(int.class.getTypeName());
        System.out.println(Integer.class.getTypeName());
        System.out.println(double[].class.getTypeName());
        System.out.println(Class.class.getTypeName());
        System.out.println(Comparable.class.getTypeName());
        System.out.println(Comparator.class.getTypeName());*/

        /*System.out.println(Arrays.toString(Class.class.getGenericInterfaces()));
        System.out.println(Arrays.toString(String.class.getGenericInterfaces()));
        System.out.println(Arrays.toString(int.class.getGenericInterfaces()));
        System.out.println(Arrays.toString(int[].class.getGenericInterfaces()));
        System.out.println(Arrays.toString(Integer[].class.getGenericInterfaces()));*/

        /*System.out.println(methods1[0].getGenericReturnType());
        System.out.println(methods2[0].getGenericReturnType());
        System.out.println(methods2[1].getGenericReturnType());*/

        /*System.out.println();
        System.out.println(Arrays.toString(methods1[0].getParameterTypes()));
        System.out.println(Arrays.toString(methods2[0].getParameterTypes()));
        System.out.println(Arrays.toString(methods2[1].getParameterTypes()));
        System.out.println(Arrays.toString(methods2[2].getParameterTypes()));
        System.out.println(Arrays.toString(methods2[3].getParameterTypes()));
        System.out.println(Arrays.toString(methods2[4].getParameterTypes()));*/
        System.out.println(Class.class.getName());
        System.out.println(Class.class);
        System.out.println(Class.class.getGenericSuperclass());
    }
}
