package AboutInterface.InterfaceConflict;

public interface IA {
    int i = 10;
    int j = 20;
    default void print(){
        System.out.println("IA!");
    }

    default String getName(){
        return "IAName";
    }

    public static void Method1(){
        System.out.println("Method1");
    }
}
