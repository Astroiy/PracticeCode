package AboutInterface.ProccessingLambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        /**模拟重复人名数组数据*/
        Random rand = new Random(47);
        ArrayList<String> names= new ArrayList<>();
        for(int i=0;i<18;i++){
            int seed = rand.nextInt(1,7);
            switch(seed){
                case 1: names.add("Tiny");break;
                case 2: names.add("Amy");break;
                case 3: names.add("Bunny");break;
                case 4: names.add("Coraline");break;
                case 5: names.add("Micheal");break;
                default:names.add(null);break;
            }
        }
        ArrayList<String> names_cloned = (ArrayList<String>) names.clone();
        System.out.println(names);

        /**去除符合条件的元素*/
        names.removeIf(Objects::isNull);
        System.out.println(names);

        names.removeIf(Predicate.isEqual("Tiny"));
        System.out.println(names);

        names.removeIf(Predicate.isEqual("Amy").or(Predicate.isEqual("Bunny")));
        System.out.println(names);

        names.removeIf(x->"Coraline".equals(x) || "Micheal".equals(x));
        System.out.println(names);

        System.out.println(names_cloned);
        //names_cloned.removeIf(Predicate.not(Predicate.isEqual("Tiny")));
        names_cloned.removeIf(Predicate.isEqual("Tiny").negate());
        System.out.println(names_cloned);
    }
}
