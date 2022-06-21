package GenericClass.WithException;

import java.io.IOException;

public class TrickingCompiler {
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable t) throws T{
        throw (T) t;
    }

    public static void main(String[] args) {
        TrickingCompiler.<RuntimeException>throwAs(new IOException());
    }
}
