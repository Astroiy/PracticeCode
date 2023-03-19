package FileAndIO;

import java.io.*;

public class TryComBineStream {
    public static void main(String[] args) {
        try(PushbackInputStream in =
                new PushbackInputStream(
                new BufferedInputStream(
                        new FileInputStream(System.getProperty("user.dir")+"/IOPractice/bytedata.bat")
                ),5
        )) {
            int c;
            while((c=in.read())!=-1){
                System.out.println(c);
                if(c==100 || c==101){
                    in.unread(1);
                    in.unread(2);
                    in.unread(new byte[]{3,4});
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
