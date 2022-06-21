package AboutInterface.FactoryPatterns;

public class Factories {
    public static void serviceConsumer(ServiceFactory serviceFactory){
        Service s = serviceFactory.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args) {
        Factories.serviceConsumer(new Service1Factory());
        Factories.serviceConsumer(new Service2Factory());
    }
}
