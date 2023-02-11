package CollectionsLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionMethods {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        var arr1 = list.toArray(l->{
            return new Integer[l];
        });
        var arr2 = list.toArray(Integer[]::new);
        var arr3 = list.toArray(l->{
                return new Integer[15];
        });
        var arr4 = list.toArray(l->{
            return new Integer[5];
        });
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        Arrays.sort(arr4);
        System.out.println(Arrays.toString(arr4));

    }
}
