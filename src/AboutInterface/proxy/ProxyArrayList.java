package AboutInterface.proxy;

import java.util.*;

public class ProxyArrayList<E> extends AbstractList<E> {

    private ArrayList<E> list = new ArrayList<E>();

    public ProxyArrayList(Collection<? extends E> c){
        list.addAll(c);
    }

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public boolean remove(Object o) {
            boolean b =false;
            while(list.remove(o)){
                b=true;
            }
            return b;
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

}
