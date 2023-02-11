package StaticExtendsLearn;

public class ExtendStatic extends StaticMethodClass{
    public static void main(String[] args) {
        ExtendStatic e = new ExtendStatic();
        e.method0();
        method1();
        ExtendStatic.method2();
        StaticMethodClass.method3();
    }
}
