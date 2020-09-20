package io.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
    public static void main(String[] args) throws Exception{
        // 1. 得到一个ServerSocketChannel对象 --> 老大
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 2. 得到一个Selector对象 --> 间谍
        Selector selector = Selector.open();
        // 3. 绑定一个端口号
        serverSocketChannel.bind(new InetSocketAddress(9999));
        // 4. 设置非阻塞方式
        serverSocketChannel.configureBlocking(false);
        // 5. 把ServerSocketChannel对象注册给Selector对象
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6. 干活
        while(true){
            // 6.1 监控客户端
            if (selector.select(2000) == 0){
                System.out.println("server：没有客户端搭理我，我就干点别的！"); // nio优势体现
                continue;
            }
            // 6.2 得到SelectionKey，判断通道里的事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()){
                    System.out.println("OP_ACCEPT");
                    // 获取通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 设定为非阻塞式io
                    socketChannel.configureBlocking(false);
                    // 将通道纳入间谍的管理范围之内
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if(key.isReadable()){ // 读取客户端数据事件
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发来数据了："+new String(buffer.array()));
                }
            }
            keyIterator.remove();
        }

    }
}
