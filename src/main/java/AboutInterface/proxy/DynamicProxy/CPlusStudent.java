package AboutInterface.proxy.DynamicProxy;

public class CPlusStudent implements Programmer{
    @Override
    public void coding() {
        System.out.println("Coding c++...");
    }

    @Override
    public String toString() {
        return "CPlusStudent{}";
    }
}
