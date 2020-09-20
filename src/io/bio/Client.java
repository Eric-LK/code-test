package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            while (true){
                // 创建socket对象
                Socket s = new Socket("127.0.0.1", 9999);
                // 从连接中取出输出流并发消息
                OutputStream os = s.getOutputStream();
                System.out.println("请输入：");
                //
                Scanner sc =new Scanner(System.in);
                String msg = sc.nextLine();
                os.write(msg.getBytes());
                // 从连接中取出输入流并就收回话
                InputStream is = s.getInputStream();
                byte[] b = new byte[20];
                is.read(b);
                System.out.println("老板说：" + new String(b).trim());
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
