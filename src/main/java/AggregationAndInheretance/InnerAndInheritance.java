package AggregationAndInheretance;

public class InnerAndInheritance {
    public static void main(String[] args) {
        B b = new B();
        B.InnerA ba = b.new InnerA();
        A.InnerA aa = b.new InnerA();
        ba.InnerClassMethod1();
        aa.InnerClassMethod2();
        System.out.println(ba instanceof A.InnerA);
        System.out.println(aa instanceof B.InnerA);
        A.InnerStaticA staticA = new A.InnerStaticA();
        staticA.StaticInnerClassMethod();
        B.InnerStaticA.SStaticInnerClassMethod();
    }
}

class A  {
    public class InnerA{
        private String field1;
        private String field2;
        public void InnerClassMethod1(){
            System.out.println("Do something1");
        }

        public void InnerClassMethod2(){
            System.out.println("Do something2");
        }
    }
    public static class InnerStaticA{
        public void StaticInnerClassMethod(){
            System.out.println("Do static something");
        }
        public static void SStaticInnerClassMethod(){
            System.out.println("Do static something");
        }
    }
     public interface InterfaceA{
        void interfaceMethod1();
    }
    private interface InterfaceB{
        void interfaceMethod2();
    }
    public class InnerA1 implements InterfaceB{
        @Override
        public void interfaceMethod2() {
            System.out.println("Implement InterfaceB");
        }
    }
}

class B extends A implements A.InterfaceA{
    @Override
    public void interfaceMethod1() {
        System.out.println("Do interfaceSomethings");
    }

}

class C extends A{
    class CImplA implements A.InterfaceA{
        @Override
        public void interfaceMethod1() {
            System.out.println("Implement interface");
        }
    }

    class CImplB implements A.InterfaceA{
        @Override
        public void interfaceMethod1() {
            System.out.println("Implement interface");
        }
    }
}
