package TCPLearn.SingleThreadChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        InputStream netInt = socket.getInputStream();
        OutputStream netOut = socket.getOutputStream();

        Scanner sc = new Scanner(System.in);
        byte[] bytes = new byte[1024];
        int len = 0;
        while(true){
            System.out.println("请输入要发送的信息");
            String msg = sc.next();

            netOut.write(msg.getBytes());
            if("886".equals(msg))
                break;
            len = netInt.read(bytes);
            String str = new String(bytes,0,len);
            System.out.println("收到信息: "+str);
            if("886".equals(str))
                break;
        }

        netInt.close();
        netOut.close();
        socket.close();
    }
}
