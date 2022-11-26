package FileAndIO;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        File file1 = new File("abc.txt");
        File file2 = new File("D:\\c_java_python\\java\\IdealJC\\Project\\CorePractice\\abc1.txt");
        System.out.println(file1);
        System.out.println(file2);

        System.out.println("绝对路径: "+file1.getAbsolutePath());
        System.out.println("构造路径: "+file1.getPath());

        System.out.println("file1的文件大小: "+file1.length());
        System.out.println("file2的文件大小: "+file2.length());

        var file3 = new File("D:\\c_java_python\\java\\IdealJC\\Project\\PracticeFiles\\directory\\aaa.txt");
        var file4 = new File("D:\\c_java_python\\java\\IdealJC\\Project\\PracticeFiles");

        System.out.println("file3是否是文件: "+file3.isFile());
        System.out.println("file4是否是目录: "+file4.isDirectory());

        /**创建*/
        File file5 = new File("D:\\c_java_python\\java\\IdealJC\\Project\\PracticeFiles\\Create.txt");
        try {
            System.out.println("创建文件:"+file5.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File dir1 = new File("D:\\c_java_python\\java\\IdealJC\\Project\\PracticeFiles\\CreateDirectory");
        System.out.println("创建单级目录:"+dir1.mkdir());

        File dir2 = new File("D:\\c_java_python\\java\\IdealJC\\Project\\PracticeFiles\\CreateMultiLayerDirectory" +
                "\\FirstLayer\\SecondLayer\\LastLayer");
        System.out.println("mkdir是否创建多级目录"+dir2.mkdir());
        System.out.println("mkdirs是否创建多级目录"+dir2.mkdirs());

        System.out.println("删除file1:"+file1.delete());
        System.out.println("删除file2:"+file2.delete());
        System.out.println("删除file3:"+file3.delete());
        System.out.println("删除file4:"+file4.delete());
        System.out.println("删除file5:"+file5.delete());
        System.out.println("删除dir1:"+dir1.delete());
        System.out.println("删除dir2:"+dir2.delete());

    }
}
