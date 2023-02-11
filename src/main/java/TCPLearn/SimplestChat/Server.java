package TCPLearn.SimplestChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /*构造时会向系统申请7777端口，如果此端口被其他程序占用，则抛出异常。如果可以使用则构造成功*/
        ServerSocket server = new ServerSocket(7777);


        /*等待客户端连接*/
        System.out.println("等待客户端连接");
        Socket socket = server.accept();
        System.out.println("连接客户端成功");

        /*获取一条信息*/

        InputStream ips = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = ips.read(bytes);
        String msg = new String(bytes, 0, len);
        System.out.println("接收信息: " + msg);

        /*发送一条信息*/
        OutputStream out = socket.getOutputStream();
        out.write("啥也不吃".getBytes());

        /*关闭连接*/
        socket.close();
        server.close();


    }
}
