package CollectionsLearn.Lists;
import java.util.*;
public class ConcurrentModificationsExceptions {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("First","Second","Third","Fourth"));
        List<String> list2 = new LinkedList<>(list1);
        System.out.println(list1);
        System.out.println(list2);
        var it1 = list1.iterator();
        var it2 = list2.listIterator();
        int count = 0;
        try{
            while(it1.hasNext()){
                //boolean b = it1.hasNext();
                //if(count==1)
                    //continue;
                String s = it1.next();
                if(s.equals("Second")) {
                    list1.remove(s);
                    list1.remove("Third");
                }
            }
        }catch(ConcurrentModificationException e){
            System.out.println("出现并发修改异常");
        }
        System.out.println(list1);
        try{
            while(it2.hasNext()){
                count++;
                String s = it2.next();
                if(count==3)
                    System.out.println(it2.nextIndex());
                if(s.equals("Third")) {
                    list2.remove(s);
                    System.out.println(it2.nextIndex());
                }
            }
        }catch(ConcurrentModificationException e){
            System.out.println("出现并发修改异常");
        }
    }

    public static class AnotherTest{
        public static void main(String[] args) {
            List<String> list = new ArrayList<String>();
            list.add("aaa");
            list.add("bbb");
            list.add("ccc");
            list.add("ddd");
            var it = list.iterator();
            while(it.hasNext()){
                String s = it.next();
                if(s.equals("ccc"))
                    list.add("itcast");
            }
        }
    }
}
