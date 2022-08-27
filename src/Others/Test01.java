package Others;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class Test01 {
    public static void main(String[] args) throws IOException {
        //创建输入流
        FileInputStream fis = new FileInputStream("day10\\123.txt");
        //创建输出流
        FileOutputStream fos = new FileOutputStream("day10\\复制.txt");
        //一次读取多个字节
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read()) != -1){
            //一次写出多个字节
            fos.write(bytes,0,len);
        }
        //关流
        fos.close();
        fis.close();
    }
}
