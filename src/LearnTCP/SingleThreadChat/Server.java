package LearnTCP.SingleThreadChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        InputStream netInt = socket.getInputStream();
        OutputStream netOut = socket.getOutputStream();

        Scanner sc = new Scanner(System.in);
        byte[] bytes = new byte[1024];
        int len = 0;
        while(true){
            len=netInt.read(bytes);
            String msg = new String(bytes,0,len);
            System.out.println("收到信息: "+msg);
            if("886".equals(msg))
                break;

            System.out.println("请输入发送的信息: ");
            String str = sc.next();
            netOut.write(str.getBytes());
            if("886".equals(str))
                break;
        }

        socket.close();
        server.close();
    }
}
