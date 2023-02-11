package TCPLearn.MultiThreadsChat;

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

        Runnable r = ()->{
            try {
                while(true){
                    byte[] bytes = new byte[1024];
                    int len = netInt.read(bytes);
                    String msg = new String(bytes,0,len);
                    System.out.println("收到信息: "+msg);
                    if("886".equals(msg))
                        System.exit(0);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(r).start();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("输入要发送的信息:");
            String msg = sc.next();
            netOut.write(msg.getBytes());
            if("886".equals(msg))
                System.exit(0);
        }
    }
}
