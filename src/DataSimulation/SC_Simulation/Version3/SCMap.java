package DataSimulation.SC_Simulation.Version3;
import java.lang.StringBuilder;
import java.util.*;

public class SCMap {

    private LinkedHashMap<Integer,TreeSet> sc_map = new LinkedHashMap<Integer,TreeSet>();

    public LinkedHashMap getSc_map(){
        return sc_map;
    }

    public String toString() {
        int kn = this.getSc_map().keySet().size();
        StringBuilder builder = new StringBuilder();
        for (Object st_id : this.getSc_map().keySet()) {
            for(Object course_id : this.sc_map.get(st_id)){
                builder.append("("+st_id+","+course_id+")"+",");
            }
        }
        return builder.toString();
    }



}
