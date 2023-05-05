package com.kai.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTrans_Server {
    public static void main(String[] args) {
        try(ServerSocket server  =new ServerSocket(8080)){
            System.out.println("等待客户端连接....");
            Socket socket =server.accept();
            System.out.println("已连接，地址为："+socket.getInetAddress()+socket.getLocalAddress());
            FileInputStream fileInputStream = new FileInputStream("test.txt");
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int i;
            while ((i=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,i);
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
