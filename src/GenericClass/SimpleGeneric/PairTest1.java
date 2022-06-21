package GenericClass.SimpleGeneric;

import java.lang.reflect.Type;

public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary","had","a","little","lamb"};
        Pair<String> mm = ArrayAlg.min_max(words);
        System.out.println("min = "+mm.getFirst());
        System.out.println("max = "+mm.getSecond());
    }
}


