package net;

import java.io.*;
import java.net.Socket;

public class ThreadServer extends Thread {
    private Socket socket;
    PrintWriter out;
    BufferedReader in;

    public ThreadServer(Socket socket) {
        this.socket = socket;
        this.initIo();
    }

    public void initIo(){
        if(this.socket != null){
            try {
                this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.out = new PrintWriter(socket.getOutputStream(),true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void run(){
        //System.out.println("服务器接收到了socket，已经启动线程！！！");
        String name = null;
        try {
            name = in.readLine();//等你的名字
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                String inputFromClien = in.readLine();
               // System.out.println(name + ":" + inputFromClien);
                out.println("已经收到[" + name + "]的信息:" + inputFromClien);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
