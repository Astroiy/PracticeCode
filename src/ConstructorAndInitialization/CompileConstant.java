package ConstructorAndInitialization;

import java.lang.reflect.Field;
import java.util.Date;

public class CompileConstant {
    private final String constant = "CompileConstant";
    private final MutableThing thing = new MutableThing("unchanged");
    public  void changeByReflection(CompileConstant cc){
        try {
            Class cl = cc.getClass();
            Field field1 = cl.getDeclaredField("constant");
            field1.setAccessible(true);
            field1.set(cc,"Changed");

            Field field2 = cl.getDeclaredField("thing");
            field2.setAccessible(true);
            field2.set(cc,new MutableThing("changed"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public MutableThing getThing() {return thing;}
    public String getConstant() {return constant;}

    public static void main(String[] args) throws ReflectiveOperationException {
        var target = new CompileConstant();
        System.out.println("反射前:\n"+new ObjectAnalyzer().toString(target));
        System.out.println(target.getConstant());
        System.out.println(target.getThing());
        target.getThing().setMutable("Changed1");
        System.out.println("用变异方法改变域Thing对象的域而不改变其指向的对象:\n"+target.getThing());

        target.changeByReflection(target);

        System.out.println("反射后:\n"+new ObjectAnalyzer().toString(target));
        System.out.println(target.getConstant());
        System.out.println(target.getThing());
        System.out.println();
    }
}
class MutableThing{
    private String mutable;
    public MutableThing(String mutable){
        this.mutable = mutable;
    }

    public void setMutable(String mutable) {
        this.mutable = mutable;
    }
    public String toString(){
        return "Content: "+mutable;
    }
}