package test1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class test {
    public static void main(String[] args) throws Exception {
        //创建一个服务器
        ServerSocket serverSocket = new ServerSocket(9876);
        Socket accpet = serverSocket.accept();
        InputStream inputStream = accpet.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bs = new byte[1024];
        int len;
        while (true){
            int read = bufferedInputStream.read(bs);
            if(read == -1){
                break;
            }
            System.out.println(new String(bs,0,read));
        }
        OutputStream outputStream = accpet.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.flush();
    }
}
