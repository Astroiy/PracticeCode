package DataSimulation.SC_Simulation.Version3;
import java.lang.StringBuilder;
import java.util.*;

/** A {@code SCMap} object store a list of id-course pair.
 * Patterns.Singleton.Student id is of Integer type , and courses attach to him are of TreeSet type.
 * @author Astroiy
 * @version 1.0.0*/
public class SCMap {

    private LinkedHashMap<Integer,TreeSet> sc_map = new LinkedHashMap<Integer,TreeSet>();
    /** Help get the instance filed of specified object.
     * @return LinkedHahMap*/
    public LinkedHashMap getSc_map(){
        return sc_map;
    }
    /** Override toString method of this class's object
     * @return String*/
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
