package io.file;

import java.io.*;

public class ConversionFlow {
    public static void main(String[] args) throws IOException {
        //获取键盘录入对象
        InputStream in = System.in;
        //将字节流对象转成字符流对象，使用转换流
        InputStreamReader isr = new InputStreamReader(in);
        //为了提高效率，将字符串进行缓冲区技术高效操作。使用BufferedReader
        BufferedReader bufferedReader = new BufferedReader(isr);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while((line = bufferedReader.readLine())!=null){
            if ("over".equals(line)){
                break;
            }
            bufferedWriter.write(line.toUpperCase());
            bufferedWriter.newLine();
            bufferedWriter .flush();
        }
        bufferedReader.close();
    }


}
