package io.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            for (;;){
                // 监听客户端
                Socket s = ss.accept();
                // 从连接中取出输入流来接收消息
                InputStream inputStream =s.getInputStream();
                //
                 byte[] b = new byte[10];
                 inputStream.read(b);
                String clientIp = s.getInetAddress().getHostAddress();
                System.out.println(clientIp + "说：" + new String(b).trim());
                // 从链接中取出输出流并回话
                OutputStream os = s.getOutputStream();
                os.write("no money".getBytes());
                s.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
