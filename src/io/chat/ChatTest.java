package io.chat;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChatTest {
    public static void main(String[] args) throws Exception{
        ChatClient chatClient = new ChatClient();

        new Thread(() -> {
            while(true){
                try {
                    chatClient.receiveMsg();
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }
}
