package PolimorphicTrap;

public class OverrideMethod extends PrivateMethod{

    public int i=10;

    public void Method1(){
        System.out.println("Public Method1");
    }

    @Override
    public void Method2(){
        System.out.println("Override Public Method2");
    }

}

class Test{
    public static void main(String[] args) {
        PrivateMethod origin = new OverrideMethod();
        origin.Method2();
    }
}