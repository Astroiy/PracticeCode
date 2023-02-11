package CollectionsLearn.MapsAndProperties;

import java.util.Map;
import java.util.Properties;

public class LearnProperties {
    public static void main(String[] args) {
        Properties p = new Properties();
        p.put("First",1);
        p.put("Second",2);
        p.put("Third",3);
        p.put("Fourth",4);
        System.out.println(p);
        var entries = p.entrySet();
        for(Map.Entry entry: entries){
            System.out.println(entry);
            if(entry.getKey().equals("First"))
                entries.remove(entry);
        }
        System.out.println(p);
    }
}
