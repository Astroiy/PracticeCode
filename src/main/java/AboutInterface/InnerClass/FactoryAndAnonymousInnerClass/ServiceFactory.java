package AboutInterface.InnerClass.FactoryAndAnonymousInnerClass;

public interface ServiceFactory {
    Service getServiceImpl();
}

class Service1Factory implements ServiceFactory{
    @Override
    public Service getServiceImpl() {
        return new Service() {
            @Override
            public void method1() {
                System.out.println("SI1 Method1");
            }

            @Override
            public void method2() {
                System.out.println("SI2 Method2");
            }
        };
    }
}

class Service2Factory implements ServiceFactory{
    @Override
    public Service getServiceImpl() {
        return new Service() {
            @Override
            public void method1() {
                System.out.println("SI2 Method1");
            }

            @Override
            public void method2() {
                System.out.println("SI2 Method2");
            }
        };
    }
}
