package LearnTCP.BSSimulation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("等待客户端连接...");
        while(true){
            new Thread(()->{
                try {
                    Socket socket = server.accept();
                    System.out.println("客户端连接成功");

                    //读取请求内容,浏览器发送的一个请求包括了很多内容,并且为按行发送
                    //BufferedReader读取,要将字节输入流转化为字符缓冲输入流
                    //利用转换流实现


                    InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                    BufferedReader bufIn = new BufferedReader(isr);
                    String row = null;
        /*while((row=bufIn.readLine())!=null){
            System.out.println("读取的行: "+row);
        }*/
                    row= bufIn.readLine();
                    String[] s = row.split(" ");

                    if(s==null || s.length!=3)
                        socket.close();
                    System.out.println("请求的文件名: "+s[1]);


                    //向客户端产生响应
                    OutputStream netOut = socket.getOutputStream();
                    netOut.write("HTTP/1.1 200 OK\r\n".getBytes());
                    netOut.write("content-type:image/jpeg\r\n".getBytes());
                    netOut.write("\r\n".getBytes());

                    //向客户端发送图片内容
                    try (FileInputStream fileIn = new FileInputStream(s[1].substring(1))) {
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = fileIn.read(bytes)) != -1) {
                            netOut.write(bytes, 0, len);
                        }
                    }catch(IOException e){
                        System.out.println("没找到文件"+s[1].substring(1));
                    }
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
