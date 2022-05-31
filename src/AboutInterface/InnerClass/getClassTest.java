package AboutInterface.InnerClass;

public class getClassTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        /**测试DotThis类中覆盖的equals方法*/
        DotThis dotThis1 = new DotThis();
        DotThis dotThis2 = new DotThis();
        DotThis dotThis3 = new DotThis("dt3_outer1","dt3_outer2");
        DotThis dotThis4 = new DotThis("dt4_outer1","dt4_outer2");
        DotThis dotThis5 = new DotThis("dt4_outer1","dt4_outer2");
        System.out.println(dotThis1.equals(dotThis2));
        System.out.println(dotThis3.equals(dotThis1));
        System.out.println(dotThis3.equals(dotThis4));
        System.out.println(dotThis4.equals(dotThis5));
        System.out.println(dotThis1.getClass());
        System.out.println("================================================");


        /**测试DotThis内部类对象关联的外部类对象*/
        DotThis.Inner dtInner1_1 = dotThis1.new Inner();
        DotThis.Inner dtInner1_2 = dotThis1.new Inner("inner1_2","inner1_2");
        DotThis.Inner dtInner2_1 = dotThis2.new Inner();
        System.out.println(dtInner1_2.get_innerOuter()==dtInner1_1.get_innerOuter());
        System.out.println(dtInner1_2.get_innerOuter()==dtInner2_1.get_innerOuter());
        System.out.println(dtInner1_1.getClass());
        System.out.println("================================================");

        /**测试在该类中创建继承DotThis类的内部类对象*/
        DotThis anonymous1 = new DotThis(){
            private String ano;
        };

        DotThis anonymous2 = new DotThis("anonymous2","anonymous2"){
            private String ano;
        };
        DotThis anonymous3 = new DotThis(){
            private String ano;
        };
        System.out.println(anonymous1.getClass());
        System.out.println(anonymous2.getClass());
        System.out.println(anonymous3.getClass());
        System.out.println(dotThis1.getClass());
        System.out.println(dtInner1_1.getClass());
        System.out.println(anonymous1.equals(anonymous3));
        /**利用该类中创建的继承DotThis类的匿名内部类对象创建DotThis类的内部类对象*/
        DotThis.Inner another = anonymous1.new Inner();
        System.out.println(another.getClass());
        System.out.println("================================================");

        /**利用DotThis中的方法创建定义在DotThis类方法中的匿名内部类对象*/
        var got_anonymous1 = dotThis1.getAnonymousObject();
        DotThis got_anonymous2 = dotThis1.getAnonymousObject();
        DotThis got_anonymous3 = dotThis3.getAnonymousObject();
        System.out.println(got_anonymous1.getClass());
        System.out.println(got_anonymous2.getClass());
        System.out.println(got_anonymous1==got_anonymous2);
        System.out.println(got_anonymous1.getClass()==got_anonymous2.getClass());
        System.out.println(got_anonymous1.equals(got_anonymous2));
        System.out.println(got_anonymous1.getClass()==got_anonymous3.getClass());
        System.out.println(got_anonymous1.equals(got_anonymous3));
        System.out.println(got_anonymous3.getClass());

        DotThis got_anonymous4 = dotThis1.getAnonymousObject1();
        System.out.println(got_anonymous4.getClass());
        System.out.println(got_anonymous4.getClass().getEnclosingClass());

    }
}
