package LearnTCP.SimplestChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //Socket socket = new Socket("127.0.0.1",7777);
        Socket socket = new Socket("192.168.58.1",7777);
        System.out.println("连接成功");

        /*发送一条信息*/
        OutputStream ops = socket.getOutputStream();
        ops.write("中午吃点啥呢".getBytes());

        /*接收一条信息*/
        InputStream ips = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = ips.read(bytes);
        String msg = new String(bytes,0,len);
        System.out.println("客户端收到反馈: "+msg);

        /*关闭连接*/
        socket.close();

    }
}
