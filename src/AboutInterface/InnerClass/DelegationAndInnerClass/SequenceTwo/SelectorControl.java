package AboutInterface.InnerClass.DelegationAndInnerClass.SequenceTwo;

import AboutInterface.InnerClass.DelegationAndInnerClass.SequenceOne.Selector;

public class SelectorControl implements SelectorDelegationByOrder{
    private int i=0;
    @Override
    public boolean end(int size) {
        return i==size;
    }
    @Override
    public Object current(Object[] objects) {
        try{
            return objects[i];
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void next(Object[] objects) {
        if(i<objects.length)
            i++;
    }
}
