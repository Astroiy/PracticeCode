package LearcCollections;

import java.util.AbstractCollection;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Objects;

public class GenericUtilsMethods {
    public static <E> boolean contains(Collection<E> e, Object obj){
        for(E element: e){
            if(e.equals(obj))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
