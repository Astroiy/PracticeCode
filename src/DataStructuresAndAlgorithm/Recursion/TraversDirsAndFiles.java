package DataStructuresAndAlgorithm.Recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class TraversDirsAndFiles {
    public static ArrayList<File> deepListFiles(File file) {
        ArrayList<File> allFiles = new ArrayList<>();
        if(file.isFile()){
            allFiles.add(file);
        }
        else{
            File[] files = Objects.requireNonNull(file.listFiles());
            for (File f : files) {
               allFiles.addAll(deepListFiles(f));
            }
        }
        return allFiles;
    }

    public static void main(String[] args) {
        File file = new File("D:\\c_java_python");
        long startTime = System.currentTimeMillis();
        ArrayList<File> result = deepListFiles(file);
        long duration = System.currentTimeMillis()-startTime;
        System.out.println("共搜索到文件: "+result.size()+"个");
        //System.out.println("所有文件路径: ");
        //result.forEach(x-> System.out.println(x.getAbsolutePath()));
        long dataSize = 0;
        for (File f : result) {
            dataSize+=f.length();
        }
        System.out.println("该目录大小: "+dataSize+"字节 "+dataSize/(1024*1024)+"M");
        System.out.println("耗时: "+duration+"毫秒");
    }
}
