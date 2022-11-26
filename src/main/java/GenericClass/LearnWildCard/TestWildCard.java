package GenericClass.LearnWildCard;
import GenericClass.SimpleGeneric.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestWildCard {
    public static void main(String[] args) {
        var ceo = new Manager("CEO",33,10000.0,5000.0);
        var cfo = new Manager("CFO",35,11000.0,5000.0);
        var managerBuddies = new Pair<Manager>(ceo,cfo);
        var employeeBuddies = new Pair<Employee>(new Employee(),new Employee());
        Pair<? extends Employee> wildcardBuddies = managerBuddies;
        // wildcardBuddies=employeeBuddies;
        System.out.println(wildcardBuddies.getFirst());

        Pair<? super Employee> superCard;
        superCard = new Pair<Employee>(new Employee(),new Employee());
        //Employee e = superCard.getFirst();
        Object obj = superCard.getFirst();
        System.out.println(obj instanceof Employee);
        Employee another  = (Employee) obj;
        superCard.setFirst(new Executor());
        //superCard.setFirst(new Person());

        Pair<Object> objectPair= new Pair<Object>();
        Pair<Employee> employeePair=new Pair<Employee>();
        Pair<Manager> managerPair= new Pair<Manager>();
        TestWildCard.min_max_Bonus(new Manager[]{ceo,cfo},employeePair);
        TestWildCard.min_max_Bonus(new Manager[]{ceo,cfo},objectPair);
        TestWildCard.min_max_Bonus(new Manager[]{ceo,cfo},managerPair);
        System.out.println();
        System.out.println(objectPair.getFirst());
        System.out.println(objectPair.getSecond());
        System.out.println(employeePair.getFirst());
        System.out.println(employeePair.getSecond());
        System.out.println(managerPair.getFirst());
        System.out.println(managerPair.getSecond());
    }
    public static void min_max_Bonus(Manager[] managers,Pair<? super Manager> result){
        if(managers.length==0)
            return;
        Manager min = managers[0];
        Manager max = managers[0];
        for(int i=1;i<managers.length;i++){
            if(min.getBonus()>managers[i].getBonus())
                min=managers[i];
            if(max.getBonus()<managers[i].getBonus())
                max=managers[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void printPair(Pair<? extends Employee> values){
        System.out.println(values.getFirst());
        System.out.println(values.getSecond());

    }

    public static class Test{
        public static void main(String[] args) {
            printArrayList(new ArrayList<String>(Arrays.asList("First","Second","Third")));
        }
    }
    public static void printArrayList(ArrayList<?> values){
        System.out.println(values);
    }

}
