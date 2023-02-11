package CollectionsLearn.Iterators;

import java.util.*;

public class ConCurrentModifyMore {
    public static class Test1{
        public static void main(String[] args) {
            HashSet<String> set = new HashSet<String>(Set.of("First","Second","Third"));
            Iterator<String> iterator = set.iterator();
            set.remove("Second");
            set.remove("Third");
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
    public static class Test2{
        public static void main(String[] args) {
            ArrayList<String> list = new ArrayList<>(List.of("First","Second","Third"));
            Iterator<String> iterator = list.iterator();
            list.set(1,"SecondChanged");
            /*list.remove(1);
            list.remove(2);*/   //抛异常
            list.clear();   //或者list.removeAll(list);
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

    public static class Test3{
        public static void main(String[] args) {
            LinkedList<String> strings = new LinkedList<String>(List.of("First","Second","Third","Fourth","Fifth"));
            ListIterator<String> it1 = strings.listIterator();
            ListIterator<String> it2 = strings.listIterator();

            System.out.println("遍历一:"+it1.next());
            it1.set("ChangedFirst");

            System.out.println("遍历二:"+it2.next());
            System.out.println("遍历二:"+it2.next());
            it2.set("ChangedSecond");

            System.out.println("遍历一:"+it1.next());
            it1.add("AddedBeforeSecond");
            while(it1.hasNext()){
                System.out.println("遍历一:"+it1.next());
            }
            System.out.println(strings);

            System.out.println("遍历二上一次元素序号"+it2.previousIndex());
            it2.remove();
            //it2.next();    抛异常

        }
    }
}
