package FileAndIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileOutput {
    public static void main(String[] args) throws IOException {
        File dir = new File("D:\\c_java_python\\java\\IdealJC\\Project\\CorePractice" +
                "\\IOPractice");
        dir.mkdir();
        File file = new File("D:\\c_java_python\\java\\IdealJC\\Project\\CorePractice" +
                "\\IOPractice\\aaa.txt");
        file.createNewFile();
        try(FileOutputStream out1 = new FileOutputStream(file,true)){
            out1.write(52);
            String s = "我爱中国";
            var cp = s.offsetByCodePoints(0,4);
            out1.write(cp);
            out1.write(s.getBytes(StandardCharsets.UTF_8));
            out1.write("\r\nnext".getBytes(StandardCharsets.UTF_8));
            out1.write(32);
            out1.write(32);
            out1.write(32);
            out1.write(52);
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
