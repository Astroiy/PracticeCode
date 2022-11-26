package Others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Fu f = new Zi();
        Zi z = new Zi();
        System.out.println(f.num);
        System.out.println(z.num);

    }
    public static class TestSort{
        public static void main(String[] args) {
            List<String> words = new ArrayList<>();
            words.add("aaa");
            words.add("aab");
            words.add("abd");
            words.add("abc");
            Collections.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            });
            System.out.println(words);
        }
    }

    public static class TestParse{
        public static void main(String[] args)
        {
            var i = Integer.parseInt("a");
            System.out.println(i);
        }

    }
}

class Fu{
    int num = 4;
}

class Zi extends Fu{
    int num = 5;
}


