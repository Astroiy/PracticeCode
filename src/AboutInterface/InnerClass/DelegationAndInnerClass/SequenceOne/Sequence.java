package AboutInterface.InnerClass.DelegationAndInnerClass.SequenceOne;

public class Sequence {
    private Object[] items;
    private int next=0;
    public Sequence(int size){
        items = new Object[size];
    }

    public void add(Object x){
        if(next<items.length)
            items[next++]=x;
    }
    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i==items.length;
        }

        @Override
        public Object current() {
            try{
                return items[i];
            }catch(RuntimeException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void next() {
            if(i<items.length)
                i++;
        }
    }
    public Selector selector(){
        return new SequenceSelector();
    }
}

class TestInner{
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i=0;i<10;i++)
            sequence.add(i);
        Selector selector = sequence.selector();
        while(!selector.end()){
            System.out.print(selector.current()+" ");
            selector.next();
        }
        System.out.println(selector.current());
    }
}

