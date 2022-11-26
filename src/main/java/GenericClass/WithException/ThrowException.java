package GenericClass.WithException;

import java.io.IOException;
import java.util.function.Supplier;

public class ThrowException {
    public static <T extends Throwable> void doWork(T t) throws T{
        try{
            int[] i = new int[4];
            i[6]=4;
        }catch(Throwable realCause){
            t.initCause(realCause);
            throw t;
        }
    }

    public static void main(String[] args) throws Throwable{
        ThrowException.doWork1(new Throwable());
    }

    public static <T extends Throwable> T getT(Supplier<T> conStr){
        return conStr.get();
    }
    public static <T extends Throwable> void doWork1(Throwable t0) throws Throwable{
        T t = (T)ThrowException.getT(IOException::new);
        throw t;
    }
}
