package AboutInterface.InterfaceConflict;

public interface IB {
    double i = 10;
    default void print(){
        System.out.println("IB!");
    }

    default String getName(){
        return "IBName";
    }

}
