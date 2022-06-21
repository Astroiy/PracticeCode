package PolimorphicTrap;

public class PrivateMethod {
    public int i = 20;
    private void Method1(){
        System.out.println("Private Method1!");
    }
    public void Method2(){
        System.out.println("Public Method2");
    }

    public static void main(String[] args) {
        PrivateMethod p = new OverrideMethod();
        OverrideMethod m = new OverrideMethod();
        p.Method1();
        p.Method2();
        m.Method1();
        m.Method2();
    }
}
