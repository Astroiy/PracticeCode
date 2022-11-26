package AboutInterface.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;
/**测试类，将想要追踪其调用方法的对象换成代理对象
 * 当其调用方法时，会转为执行代理对象关联的实现了InvocationHandler类的实例handler的invoke方法
 * 其中调用原本方法的隐式参数存储在handler对象的域中
 * 该例跟踪了二分查找的方法调用过程
 * */
public class ProxyTest {
    public static void main(String[] args) {

        var elements = new Object[1000];

        /**将桉顺序存储了1到1000整数的数组中的对象全部替换为代理对象*/
        for (int i = 0; i < elements.length; i++) {
            int values = i+1;
            var handler = new TraceHandler(values);
            Object proxy = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    new Class[]{Comparable.class},
                    handler);
            elements[i]=proxy;
        }
        /**随机选取一个想要查找的正整数*/
        Integer key = new Random().nextInt(elements.length)+1;
        int result = Arrays.binarySearch(elements,key);
        if(result>=0)
            System.out.println(elements[result]);
    }
}
/**定义实现了InvocationHandler接口的类用于跟踪方法*/
class TraceHandler implements InvocationHandler{
    private Object target;
    public TraceHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        /**打印调用方法的隐式参数*/
        System.out.print(target);
        /**打印方法名*/
        System.out.print("."+method.getName()+"(");
        if(args!=null){
            for (int i = 0; i < args.length; i++) {
                if(i!=0 && i!=args.length-1)
                    System.out.print(",");
                System.out.print(args[i]);
            }
        }
        System.out.println(")");
        /**执行原本的方法*/
        return method.invoke(target,args);
    }
}
