package GenericClass.SimpleGeneric;

import GenericClass.LearnWildCard.Employee;

import java.util.function.Supplier;

public class Pair<T> {
    private T first;
    private T second;

    private T[] array ;

    public Pair() {
        first = null;
        second = null;
    }
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {return first;}
    public T getSecond() {return second;}

    public void setFirst(T newValue) {first = newValue;}

    public void setSecond(T newValue) {second = newValue;}

    public static <T> Pair<T> makePair1(Supplier<T> supplier){
        return new Pair<>(supplier.get(),supplier.get());
    }

    public static <T> Pair<T> makePair2(Class<T> cl){
        try {
            return new Pair<>(cl.getConstructor().newInstance(), cl.getConstructor().newInstance());
        }catch(Exception e)
        {
            return null;
        }
    }

}
