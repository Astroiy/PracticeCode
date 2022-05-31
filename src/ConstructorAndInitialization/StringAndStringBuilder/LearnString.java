package ConstructorAndInitialization.StringAndStringBuilder;

import java.util.Arrays;

public class LearnString {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str1==str2);
        System.out.println(str3==str4);
        System.out.println(str2==str3);
    }

    public static class Test1{
        public static void main(String[] args) {
            String s = new String(new int[]{58,59,60,61,62},0,5);
            System.out.println(s);
            String s1 = new String(new byte[]{58,59,60,61,62,65,66},0,7);
            System.out.println(s1);
            String s2 = new String(new char[]{'a','b','c'},0,3);
            System.out.println(s2);
        }
    }
    public static class Test2{
        public static void main(String[] args) {
            String traverse ="I Love LXJ";
            String[] stringSet1 = traverse.split("",10);
            String[] stringSet2 = traverse.split("",-2);
            String[] stringSet3 = traverse.split("");
            char[] charSet1 = traverse.toCharArray();
            char[] charSet2 = new char[traverse.length()];
            for (int i = 0; i < charSet2.length; i++) {
                charSet2[i]=traverse.charAt(i);
            }
            System.out.println(Arrays.toString(stringSet1));
            System.out.println(Arrays.toString(stringSet2));
            System.out.println(Arrays.toString(stringSet3));
            System.out.println(Arrays.toString(charSet1));
            System.out.println(Arrays.toString(charSet2));
        }
    }

    public static class Test3{
        public static void main(String[] args) {
            String s = new String(new int[]{32,32,32},0,3);
            System.out.println(s);
            System.out.println(s.toCharArray().length);
            String s1= new String(new char[]{' ',' ',' '});
            System.out.println(s1);
            System.out.println(s.equals(s1));
            String s2 = s.strip();
            String s3 = s1.strip();
            String s4 = s.trim();
            String s5 = s1.trim();
            System.out.println(s2.equals(s3));
            System.out.println(s4.equals(s5));
            String space = new String(new int[]{28,29,30},0,3);
            System.out.println(space);
            System.out.println(space.trim());
            System.out.println(space.trim().length());
        }
    }
    public static class Test4{
        public static void main(String[] args) {
            String s1 = "Hello";
            StringBuilder s2= new StringBuilder(s1);
            s2.append(123);
            System.out.println(s1);
            System.out.println(s2);
        }
    }
}
