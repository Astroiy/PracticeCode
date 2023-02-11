package CollectionsLearn.Sets;

import java.util.Set;
import java.util.TreeSet;

public class IgnoreCaseTreeSet {
    public static void main(String[] args) {
        TreeSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(Set.of("aBc","AbB","aAb","ABc","bAc","Bca"));
        System.out.println(words);
    }
}
