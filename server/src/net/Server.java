package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("-------------");
        System.out.println("服务器端启动！！！");
        System.out.println("-------------");

        ServerSocket serverSocket = new ServerSocket(1314);
        int count = 0;
        while (true){
            Socket socket = serverSocket.accept();
            count++;
            System.out.println("连接数:" + count);
            new ThreadServer(socket).start();
        }
    }
}
