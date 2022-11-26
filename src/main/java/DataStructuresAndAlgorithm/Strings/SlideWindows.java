package DataStructuresAndAlgorithm.Strings;

import java.util.HashSet;

public class SlideWindows {
    public static int getLongestSubLength(String str){
        String[] letters = str.split("");
        HashSet<String> set = new HashSet<String>();
        int searchLocation=0;
        int length=0;
        for (String letter : letters) {
            for (int j = searchLocation; j < letters.length; j++) {
                int originalSize = set.size();
                set.add(letters[j]);
                if (set.size() == originalSize) {
                    searchLocation = j;
                    break;
                }
                length = Math.max(length, set.size());
                if (j == letters.length - 1)
                    return length;
            }
            set.remove(letter);
        }
        return length;
    }

    public static void main(String[] args) {
        String letters="abcdefgandhc";
        System.out.println(getLongestSubLength(letters));
    }
}
