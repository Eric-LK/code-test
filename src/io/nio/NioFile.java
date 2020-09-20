package io.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过bio进行文件的输入输出
 */
public class NioFile {

    @Test // 往本地文件中写数据
    public void test01(){
        try {
            // 1. 创建输出流
            FileOutputStream fos = new FileOutputStream("basic.txt");
            // 2. 从流中得到一个通道
            FileChannel fc = fos.getChannel();
            // 3. 提供一个缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 4. 往缓冲区中输入数据
            String str = "hello,nio";
            byteBuffer.put(str.getBytes());
            // 5. 翻转缓冲区
            byteBuffer.flip();
            // 6. 把缓冲区写到通道中
            fc.write(byteBuffer);
            // 7. 关闭
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test // 从本地文件中读取数据
    public void test02(){
        try {
            File file = new File("basic.txt");
            // 1. 创建输入流
            FileInputStream fis = new FileInputStream(file);
            // 2. 得到一个通道
            FileChannel fc = fis.getChannel();
            // 3. 准备一个缓冲区
            ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
            // 4. 从通道里读取数据并存到缓冲区中
            fc.read(buffer);
            System.out.println(new String(buffer.array()));
            // 5. 关闭
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test // 向本地复制文件
    public void test03(){
        try {
            // 创建两个流
            FileInputStream fis = new FileInputStream("basic.txt");
            FileOutputStream fos = new FileOutputStream("E:\\test\\basic.txt");
            // 得到两个通道
            FileChannel sourceFC = fis.getChannel();
            FileChannel targetFc = fos.getChannel();
            // 复制
            targetFc.transferFrom(sourceFC,0,sourceFC.size());
            // 关闭
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
