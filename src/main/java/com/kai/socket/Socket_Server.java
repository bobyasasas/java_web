package com.kai.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket_Server {
    public static void main(String[] args) {
        try(ServerSocket server  =new ServerSocket(8080)){
            System.out.println("等待客户端连接....");
            Socket socket =server.accept();
            System.out.println("已连接，地址为："+socket.getInetAddress()+socket.getLocalAddress());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
