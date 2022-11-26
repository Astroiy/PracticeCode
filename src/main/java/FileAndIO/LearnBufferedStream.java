package FileAndIO;

import java.io.*;
import java.util.Properties;

public class LearnBufferedStream {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bufo = new BufferedOutputStream(new FileOutputStream("itcast\\out.txt"));
        bufo.write("hello".getBytes());
        bufo.flush();
    }
}
