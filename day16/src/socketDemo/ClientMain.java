package socketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端");
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1",8080);
       // InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriterpr = new PrintWriter(outputStream,true);
       while (true){
           String input = scanner.nextLine();
           printWriterpr.println(input);
           System.out.println("已发送！");
       }
    }
}
