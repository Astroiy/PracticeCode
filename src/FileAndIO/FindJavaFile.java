package FileAndIO;

import java.io.File;
import java.util.Objects;

public class FindJavaFile {
    public static void main(String[] args) {
        File file = new File("D:\\c_java_python\\java\\IdealJC\\Project\\CorePractice\\src");

        File[] files = file.listFiles();
        assert files != null;
        for(File f : files){
            if(f.getName().endsWith(".java")&&f.isFile()){
                System.out.println(f.getAbsoluteFile());
            }
        }
    }
}
