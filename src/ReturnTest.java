import java.util.Scanner;

public class ReturnTest {
    public void returnTest(){
        System.out.println("Quit now");
        return;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        new ReturnTest().returnTest();
        if(i==1)
            System.out.println("1");
        if(i==0)
            return;
        System.out.println("System out");
    }
}
