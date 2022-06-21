package AboutInterface.InnerClass.FactoryAndAnonymousInnerClass;

public class Factories {
    public static void serviceConsumer(ServiceFactory serviceFactory){
        Service s = serviceFactory.getServiceImpl();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Service1Factory());
        serviceConsumer(new Service2Factory());
    }
}
