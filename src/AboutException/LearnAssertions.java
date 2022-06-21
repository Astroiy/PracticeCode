package AboutException;

import java.util.Random;
import java.util.Scanner;

public class LearnAssertions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        assert x<0:x;
        System.out.println(x);
    }
}
