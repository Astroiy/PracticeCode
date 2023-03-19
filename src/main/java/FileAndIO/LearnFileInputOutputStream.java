package FileAndIO;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.zip.ZipInputStream;

public class LearnFileInputOutputStream {

    public static void main(String[] args) throws IOException {
       Properties properties = System.getProperties();
       properties.forEach((k,v)->{
           System.out.println(k+":"+v);
       });
       String property = System.getProperty("user.dir");
       System.out.println(property);
       System.out.println(File.separator);

       DataInputStream inputStream = new DataInputStream(
               new BufferedInputStream(
                       new FileInputStream("employee.bat")
               )
       );

       PushbackInputStream pushbackInputStream = new PushbackInputStream(
               new BufferedInputStream(
                       new FileInputStream("employee.bat")
               )
       );

       int b = pushbackInputStream.read();
       if(b!='<'){
           pushbackInputStream.unread(b);
       }

        try (DataInputStream zipInputStream = new DataInputStream(
                new ZipInputStream(
                        new FileInputStream("employee.zip")
                )
        )) {
            double d = zipInputStream.readDouble();
        }

        System.out.println(inputStream);
       System.out.println(pushbackInputStream);
       inputStream.close();
       pushbackInputStream.close();

    }
}
