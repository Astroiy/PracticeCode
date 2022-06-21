package FileAndIO;

import java.io.FileWriter;
import java.io.IOException;

public class LearnFileWriter {
    public static void main(String[] args) throws IOException {
        FileWriter out = new FileWriter("IOPractice\\LearnFileWriter.txt" ,false);

        out.write('你');
        out.write('好');
        out.write('吗');
        out.write("中国人民万岁",2,4);

        out.close();   //flush+close
    }
}
