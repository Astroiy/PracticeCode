package AboutInterface.ConstructorReferences;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayConstructorReference {
    public static void main(String[] args) {
        ArrayList[] T = new ArrayList[3];
        System.out.println(Arrays.toString(T));
        System.out.println(T.getClass());
    }
}
