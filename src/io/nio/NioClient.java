package io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {
    public static void main(String[] args) throws Exception{
        // 1. 得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 2. 设置非阻塞方式
        socketChannel.configureBlocking(false);
        // 3. 提供服务器端的IP地址和端口号
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",9999);
        // 4. 连接服务器
        if(!socketChannel.connect(address)){
            while (!socketChannel.finishConnect()){
                System.out.println("客户端：连接服务器的同时，我还可以做别的事，我是nio");
            }
        }
        // 5. 得到一个缓冲区并存入数据
        String msg = "hello,nio server";
        ByteBuffer writeBuf = ByteBuffer.wrap(msg.getBytes());
        // 6. 发送数据
        socketChannel.write(writeBuf);
        //
        System.in.read();
    }
}
