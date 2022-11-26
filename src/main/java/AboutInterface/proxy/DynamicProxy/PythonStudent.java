package AboutInterface.proxy.DynamicProxy;

public class PythonStudent implements Programmer{
    @Override
    public void coding() {
        System.out.println("Coding python...");
    }

    @Override
    public String toString() {
        return "PythonStudent{}";
    }
}
