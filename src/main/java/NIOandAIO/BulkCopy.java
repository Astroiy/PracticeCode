package NIOandAIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class BulkCopy {
    public static void main(String[] args) {
        try(RandomAccessFile in = new RandomAccessFile("d:\\aaa.avi","r");
            RandomAccessFile out = new RandomAccessFile("e:\\aa.avi","rw");
            FileChannel inChannel = in.getChannel();
            FileChannel outChannel = out.getChannel();
        ){
            long filesize = inChannel.size();
            MappedByteBuffer inBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, filesize);
            MappedByteBuffer outBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, filesize);
            for (int i = 0; i < filesize; i++) {
                byte b = inBuf.get(i);
                outBuf.put(b);
            }

            System.out.println("复制完毕");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
