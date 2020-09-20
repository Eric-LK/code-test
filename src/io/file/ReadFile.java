package io.file;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args)
    {
        fileRead();
    }

    public void fileOutputSteamOut()throws IOException
    {
        FileInputStream fis = null;
        try {
            //创建字节输入流
            fis = new FileInputStream("D:\\Test\\javaTest\\src\\io\\file\\test.txt");
            //创建一个长度1024的数组
            byte[] b = new byte[1024];
            //用于保存的实际字节数
            int hasRead = 0 ;
            //使用循环来重复取数的过程
            while ((hasRead=fis.read(b))>0){
                System.out.print(new String (b,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fis.close();
        }
    }

    public static void fileRead()  {
        FileReader fr =null;
        try{
            fr = new FileReader("D:\\Test\\javaTest\\src\\io\\test.txt");
            char[] b = new char[1024];
            int hasRead = 0;
            while((hasRead = fr.read(b))>0){
                System.out.print(new String(b,0,hasRead));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
