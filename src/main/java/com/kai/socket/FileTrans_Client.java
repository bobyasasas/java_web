package com.kai.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FileTrans_Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8080)){
            System.out.println("已连接");
            InputStream stream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("net/downloadFile.txt");
            byte[] bytes = new byte[1024];
            int i;
            while((i=stream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,i);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (IOException ex){
            System.out.println("连接失败");
            ex.printStackTrace();
        }finally {
            System.out.println("连接关闭");
        }
    }
}
