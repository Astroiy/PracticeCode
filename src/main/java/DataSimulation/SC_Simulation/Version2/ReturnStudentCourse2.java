package DataSimulation.SC_Simulation.Version2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;

public class ReturnStudentCourse2 {
    public static LinkedHashSet<SCArray> getSC(int n) {
        Random rand = new Random();
        ArrayList<Integer> course = new ArrayList<Integer>(Arrays.asList(666001, 666002, 666003, 666004, 666005, 666006, 666007
                , 666008));
        LinkedHashSet<SCArray> result = new LinkedHashSet<SCArray>();
        for(int i=1;i<=n;i++){
            int scn = rand.nextInt(2,5);
            LinkedHashSet<Integer> selected = new LinkedHashSet<Integer>();
           do{
               selected.add(rand.nextInt(666001,666009));
           }while(selected.size()<scn);
           for(Integer c: selected){
               var tmp = new SCArray();
               tmp.setPair(i,c);
               result.add(tmp);
           }
        }
        return result;
    }
    public static class Test2{
        public static void main(String[] args){
            var s = getSC(50);
            System.out.println(s);
        }
    }

}
