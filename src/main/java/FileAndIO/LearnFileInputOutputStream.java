package FileAndIO;

import java.io.File;
import java.util.Properties;

public class LearnFileInputOutputStream {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        String property = System.getProperty("user.dir");
        System.out.println(property);
        System.out.println(File.separator);

    }
}
