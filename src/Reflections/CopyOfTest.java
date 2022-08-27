package Reflections;

import ConstructorAndInitialization.Teacher;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static Object goodCopyOf(Object obj,int newLength){
        Class cl = obj.getClass();
        if(!cl.isArray())
            return null;
        Class type = cl.getComponentType();
        int length = Array.getLength(obj);
        Object newArray = Array.newInstance(type,newLength);
        System.arraycopy(obj,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }

    public static Object[] badCopyOf(Object[] obj,int newLength){
        var newArray = new Object[newLength];
        System.arraycopy(obj,0,newArray,0,Math.min(Array.getLength(obj),newLength));
        return newArray;

    }


    public static class Test{
        public static void main(String[] args){
            Teacher[] t = new Teacher[3];

            for(int i=0;i<t.length;i++){
                t[i] = new Teacher();
                t[i].setName("t"+i);
                t[i].setAge(17+i);
                t[i].setMajor("Major"+i);
                t[i].setGender("Male");
            }
            Object obj = (Object) t;
            System.out.println(obj);

            Teacher[] t2 = (Teacher[]) CopyOfTest.goodCopyOf(t,2);
            Teacher[] t3 = (Teacher[]) CopyOfTest.goodCopyOf(t,5);
            System.out.println(Arrays.toString(t2));
            System.out.println(Arrays.toString(t3));

            Object[] t4 = CopyOfTest.badCopyOf(t,2);
            System.out.println(t4);

        }
    }
}
