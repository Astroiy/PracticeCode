package ConstructorAndInitialization;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Spoon {
    private static int nextId;
    static{
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }
    public static void main(String[] args){
        String s = "abcde";
        System.out.println(Arrays.toString(s.toCharArray()));
    }
}
