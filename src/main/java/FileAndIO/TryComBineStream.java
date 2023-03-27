package FileAndIO;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private static class tryDataInputStream{
        public static void main(String[] args) {
            try(DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(System.getProperty("user.dir")+"/IOPractice/bytedata.bat")
                    )
            )){
                int read = in.read();
                System.out.println(read);
                int i = in.readInt();
                System.out.println(i);
                byte b = in.readByte();
                System.out.println(b);
                char c = in.readChar();
                System.out.println(c);
                while(in.available()!=0){
                    System.out.println(in.readChar());
                }
            }catch(Exception e){
                Logger.getGlobal().log(Level.WARNING,e.getMessage(),e);
            }
        }
    }

    private static class tryOutputStream{
        public static void main(String[] args) {
            try(DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(System.getProperty("user.dir")+"/IOPractice/learnOutputStream.bat")
                    )
            )){
                out.writeInt(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
