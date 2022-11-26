package FileAndIO;

import java.io.FileReader;
import java.io.IOException;

public class LearnFileReader {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("books.xml");

        char[] chars = new char[4];
        int c = 0;
        if((c = in.read(chars))!=-1){
            System.out.println(chars);
        }
        in.close();
    }
}
