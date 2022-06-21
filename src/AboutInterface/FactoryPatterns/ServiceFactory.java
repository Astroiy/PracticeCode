package AboutInterface.FactoryPatterns;

public interface ServiceFactory {
    Service getService();
}
class Service1Factory implements ServiceFactory{
    @Override
    public Service getService() {
        return new Service1();
    }
}

class Service2Factory implements ServiceFactory{
    @Override
    public Service getService() {
        return new Service2();
    }
}
