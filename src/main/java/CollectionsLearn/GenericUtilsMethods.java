package CollectionsLearn;

import java.util.Collection;

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
