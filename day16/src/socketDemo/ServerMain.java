package socketDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动");
        ServerSocket serverSocket = new ServerSocket(8080);
        int count = 0;
        //System.out.println("ok");
        //OutputStream outputStream = socket.getOutputStream();
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("连接数：" + (++count));
            //启动一个线程，处理Socket
            new Thread(new RunnableServer(socket)).start();
        }
    }
}
