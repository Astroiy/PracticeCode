package AboutInterface.InnerClass.DelegationAndInnerClass.SequenceTwo;

public class Sequence {
    private Object[] items;
    private int next=0;
    private SelectorControl selector = new SelectorControl();
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object obj){
        if(next<items.length)
            items[next++]=obj;
        else
            System.out.println("The sequence has been full");
    }
    public boolean end(){
        return selector.end(items.length);
    }
    public Object current(){
        return selector.current(items);
    }
    public void next(){
        selector.next(items);
    }
}

class TestDelegation{
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        while(!sequence.end()){
            System.out.print(sequence.current()+" ");
            sequence.next();
        }
    }
}
