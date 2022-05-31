package ConstructorAndInitialization;

import java.lang.reflect.*;

public class MethodTableTest {
    public static Double square(Double x){
        Double y = x*x;
        return y;
    }
    public static void printTable(double from , double to, int n, Method f) throws ReflectiveOperationException,
            InValidMethod{
        System.out.println("方法所属类: "+f.getDeclaringClass().getName());
        StringBuilder builder = new StringBuilder();
        if(!Modifier.isStatic(f.getModifiers()))
            throw new InValidMethod();
        String modifiers = Modifier.toString(f.getModifiers());
        if(f.getReturnType()!=double.class && f.getReturnType()!=Double.class)
            throw new InValidMethod();
        String rtype = f.getReturnType().getName();
        String name = f.getName();
        builder.append(modifiers+" ");
        builder.append(rtype+" ");
        builder.append(name+"(");
        Class[] para = f.getParameterTypes();
        for(Class p: para){
            if(!builder.toString().endsWith("("))
                builder.append(" ,");
            String pname = p.getName();
            builder.append(pname);
        }
        builder.append("){...};");
        System.out.println("方法声名: "+builder.toString());

        double dx = (to-from)/(n-1);
        for(double x=from;x<=to;x+=dx){
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f\n", x, y);
        }
    }
    public static class Test{
        public static void main(String[] args) throws ReflectiveOperationException, InValidMethod {
            MethodTableTest.printTable(-10,10,11,Math.class.getMethod("sin",double.class));
            MethodTableTest.printTable(-10,10,11,Math.class.getMethod("exp",double.class));
            MethodTableTest.printTable(-10,10,11,MethodTableTest.class.getMethod("square", Double.class));
        }
    }
}
class InValidMethod extends Exception{};
