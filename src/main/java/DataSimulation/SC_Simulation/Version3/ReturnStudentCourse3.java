package DataSimulation.SC_Simulation.Version3;

import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class ReturnStudentCourse3 {
    public static SCMap getSC(int n,int m,int l) throws OutOfBoundsException{
        if(n>=0 && (m>=0 && l<=8)){
            Random rand = new Random();
            SCMap result = new SCMap();
            for(int i=1;i<=n;i++) {
                int scn = rand.nextInt(m, l + 1);
                TreeSet<Integer> selected_course = new TreeSet<Integer>();
                while(selected_course.size()<scn){
                    selected_course.add(rand.nextInt(666001,666009));
                }
                result.getSc_map().put(i,selected_course);
        }
            return result;
        }
        else{
            throw new OutOfBoundsException();
        }
    }

    public static class Test{
        public static void main(String[] args) throws OutOfBoundsException{
            var s = getSC(50,2,4);
            System.out.println(s);

        }
    }
}
