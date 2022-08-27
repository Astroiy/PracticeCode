package AboutInterface.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProgrammerHandler implements InvocationHandler {

    private Object target;
    public ProgrammerHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("工作者: "+target);
        System.out.println("谈价格");
        Object result = method.invoke(target);
        System.out.println("收尾款");
        return result;
    }
}

class ProgrammerTest{
    public static void main(String[] args) {
        Programmer p1 = new PythonStudent();
        Programmer proxy1 = (Programmer) Proxy.newProxyInstance(p1.getClass().getClassLoader(), new Class[]{Programmer.class},
                new ProgrammerHandler(p1));
        proxy1.coding();

        getProxy(new JavaStudent()).coding();
        getProxy(new CPlusStudent()).coding();
    }

    public static Programmer getProxy(Programmer p){
        Object proxyInstance = Proxy.newProxyInstance(p.getClass().getClassLoader(), new Class[]{Programmer.class}, new ProgrammerHandler(p));
        return (Programmer) proxyInstance;
    }
}
