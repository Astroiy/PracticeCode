package AboutInterface.proxy.DynamicProxy;

public class JavaStudent implements Programmer{

    @Override
    public void coding() {
        System.out.println("Coding java...");
    }

    @Override
    public String toString() {
        return "JavaStudent{}";
    }
}
