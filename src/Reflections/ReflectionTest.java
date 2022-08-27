package Reflections;

import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**这个类用于打印输入类的域、构造器以及方法的具体信息。
 * @author Astroiy
 * @version v1.0.0 */

public class ReflectionTest {
    public static void main(String[] args) throws ReflectiveOperationException{
        /**从命令行或者输入读取需要分析的类名*/
        String name;
        if(args.length>0)
            name = args[0];
        else{
            var in  = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        //打印类名和其基类名如果输入的类不是Object类
        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if(modifiers.length()>0)
            System.out.print(modifiers + " ");
        System.out.print("class " + name);
        if(supercl!=null && supercl!=Object.class)
            System.out.print(" extends "+supercl.getName());

        //打印域，构造器和方法信息
        System.out.print("\n{\n");
        printFields(cl);
        System.out.println();
        printConstruction(cl);
        System.out.println();
        printMethods(cl);
        System.out.print("}");
    }

    /**定义打印域信息的方法
     * @param cl a class
     */
    public static void printFields(Class cl){
        Field[] fields = cl.getFields();
        for(Field f:fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length()>0)
                System.out.print(modifiers+" ");
            System.out.println(type.getName()+" "+name+";");
        }
    }

    /**定义打印构造器信息的方法
     * @param cl a class
     */
    public static void printConstruction(Class cl){
        Constructor[] constructors = cl.getConstructors();
        for(Constructor c:constructors){
            String name = c.getName();
            Class[] para = c.getParameterTypes();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length()>0)
                System.out.print(modifiers+" ");
            System.out.print(name+"(");
            for(int i=0;i<para.length;i++){
                if(i>0)
                    System.out.print(",");
                System.out.print(para[i].getName());
            }
            System.out.println(");");
        }
    }

    /**定义打印方法信息的方法
     * @param cl a class*/
    public static void printMethods(Class cl){
        Method[] methods = cl.getMethods();
        for(Method m:methods){
            String modifiers = Modifier.toString(m.getModifiers());
            Class returntype = m.getReturnType();
            String name = m.getName();
            Class[] para = m.getParameterTypes();
            System.out.print("   ");
            if(modifiers.length()>0)
                System.out.print(modifiers+" ");
            System.out.print(returntype.getName()+" "+name+"(");
            for(int i=0;i<para.length;i++){
                if(i>0)
                    System.out.print(",");
                System.out.print(para[i].getName());
            }
            System.out.println(");");
        }
    }
}
