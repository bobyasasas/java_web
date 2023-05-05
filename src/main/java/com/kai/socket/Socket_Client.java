package com.kai.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Socket_Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8080)){
            System.out.println("已连接");
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            Scanner sc = new Scanner(System.in);
            String text = sc.nextLine();
            outputStreamWriter.write(text+'\n');
            outputStreamWriter.flush();
        }catch (IOException ex){
            System.out.println("连接失败");
            ex.printStackTrace();
        }finally {
            System.out.println("连接关闭");
        }
    }
}
