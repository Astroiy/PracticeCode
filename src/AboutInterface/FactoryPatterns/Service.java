package AboutInterface.FactoryPatterns;

public interface Service {
    void method1();
    void method2();
}

class Service1 implements Service{
    @Override
    public void method1() {
        System.out.println("Service1 Method1");
    }

    @Override
    public void method2() {
        System.out.println("Service1 Method2");
    }
}

class Service2 implements Service{
    @Override
    public void method1() {
        System.out.println("Service2 Method1");
    }

    @Override
    public void method2() {
        System.out.println("Service2 Method2");
    }
}

