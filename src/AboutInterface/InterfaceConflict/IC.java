package AboutInterface.InterfaceConflict;
import static AboutInterface.InterfaceConflict.IA.Method1;

public interface IC extends IA,IB{
    int i=0;
    default void addition(){
        System.out.println(IA.i+IB.i+i);
        IA.Method1();
        Method1();
    }

    @Override
    default void print() {
        IA.super.print();
    }

    @Override
    default String getName() {
        return IA.super.getName();
    }

    public static void Method1(){
        System.out.println("IC Method1");
    }

}

class TestInterface1 implements IC{
    public static void main(String[] args) {
        System.out.println(IA.i);
    }
}



class TestInterface2 implements IA,IB{
    private String name1 = IA.super.getName();
    private String name2 = IB.super.getName();

    @Override
    public String getName() {
        return "Name";
    }

    @Override
    public void print() {
        System.out.println("Print");
    }

    public static void main(String[] args) {

    }
}
