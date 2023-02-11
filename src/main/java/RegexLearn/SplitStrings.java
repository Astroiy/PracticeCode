package RegexLearn;

import java.util.Arrays;

public class SplitStrings {
    public static void main(String[] args) {
        String str = "aaa...,,,...bbb..,,,..ccc...,,,";
        String[] split = str.split("[.,]+");
        System.out.println(Arrays.toString(split));
    }
}
