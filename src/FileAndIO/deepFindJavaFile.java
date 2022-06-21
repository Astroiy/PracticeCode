package FileAndIO;

import java.io.File;
import java.util.Scanner;

public class deepFindJavaFile {
    public static void listFiles(File dir,String predicate) {

        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().contains(predicate)) {
                    System.out.println(f.getAbsolutePath());
                } else if (f.isDirectory()) {
                    listFiles(f,predicate);
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("D:\\c_java_python\\java\\IdealJC\\Project\\CorePractice");
        listFiles(file,".java");

    }
}
