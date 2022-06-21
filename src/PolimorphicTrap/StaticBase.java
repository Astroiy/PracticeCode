package PolimorphicTrap;


/**static方法的两种调用方式:
 * 1、根绝类名.方法名
 * 2、根据对象名.方法名
 * 第一个疑问：继承了父类中一个static方法的子类，在测试类中使用父类名和子类名调用该方法是否有区别
 * 第二个疑问：如果我在子类中写了一个同名同参数同返回类型的静态方法，那么是否会发生覆盖现在；如果我把子类对象向上转型给父类的引用，是否会产生多态行为*/

/**父类*/
public class StaticBase {

    /**测试用的public静态方法*/
    public static void staticPrint(){
        System.out.println("这是父类静态方法");
    }
}

/**子类*/
class StaticSub extends StaticBase{

    /**子类中试图覆盖的public静态方法*/
    public static void staticPrint(){
        System.out.println("这是子类静态方法");
    }
}
class TestFirst{
    public static void main(String[] args) {
        /**第一个疑问*/
        StaticBase.staticPrint();
        StaticSub.staticPrint();
    }
}
class TestPolymorphism{
    public static void main(String[] args) {
        /**第二个疑问*/
        StaticBase b = new StaticSub();
        StaticBase a = new StaticBase();
        StaticSub c = new StaticSub();

        /**静态方法不存在多态行为*/
        StaticBase d = null;
        StaticSub e = null;

        b.staticPrint();
        a.staticPrint();
        c.staticPrint();
        d.staticPrint();
        e.staticPrint();
    }
}
class TestNull{
    public static void main(String[] args) {
        String name = null;
        name.toString();
    }
}
