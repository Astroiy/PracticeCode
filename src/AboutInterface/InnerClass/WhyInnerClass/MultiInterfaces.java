package AboutInterface.InnerClass.WhyInnerClass;

interface First{
    void firstMethod();
}
interface Second{
    void secondMethod();
}

class A implements First,Second{
    @Override
    public void firstMethod() {
        System.out.println("A Implement First Interface!");
    }

    @Override
    public void secondMethod() {
        System.out.println("B Implement Second Interface!");
    }
}

class B implements First{
    @Override
    public void firstMethod() {
        System.out.println("B implement First Interface!");
    }
    public First makeFirst(){
        return new First(){
            public void firstMethod(){
                System.out.println("Innerclass of B Implement First Interface");
            }
        };
    }
    public Second makeSecond(){
        return new Second(){
            public void secondMethod(){
                System.out.println("Innerclass of B Implement Second Interface");
            }
        };
    }
}




public class MultiInterfaces {
    static void takes1(First first){
        first.firstMethod();
    }
    static void takes2(Second second){
        second.secondMethod();
    }
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        takes1(a);
        takes1(b);
        takes1(b.makeFirst());
        takes2(a);
        takes2(b.makeSecond());
    }
}
